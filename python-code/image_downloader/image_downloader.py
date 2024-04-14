import os
from pathlib import Path
import json
import requests
from threading import Thread, get_ident
from typing import Callable, List


class ImageDownloader:
    """
    Dummy image downloader. This was a coding challenge in one the Scandit interviews
    """

    def __init__(self, sources_dir: Path, target_dir: Path):
        self.sources_dir: Path = sources_dir
        self.target_dir: Path = target_dir
        self.worker_threads: List[Thread] = []

    def is_empty(self, path: Path) -> bool:
        return os.path.getsize(path.absolute()) == 0

    def get_fully_qualified_output_path(self, img_url: str) -> str:
        target_file_name = hash(img_url)
        return os.path.join(self.target_dir, 'images', f'{target_file_name}.jpg')

    def create_single_downloader_task(self, json_file: Path):
        with open(json_file) as f:
            if not self.is_empty(json_file):
                print(f'[thread_id: {get_ident()}] Processing JSON file {json_file}')
                json_content = json.load(f)
                for json_image_content in json_content:
                    img_url = json_image_content['url']
                    print(f'\t\t ... processing URL {img_url}')
                    response = requests.get(url=img_url)
                    fully_qualified_target_path = self.get_fully_qualified_output_path(img_url)
                    with open(fully_qualified_target_path, 'wb') as output_f:
                        output_f.write(response.content)
            else:
                print(f'{json_file} is empty. Skipping processing')

    def create_all_downloader_tasks(self) -> List[Thread]:
        for json_file in self.sources_dir.glob('**/*.json'):
            yield Thread(target=self.create_single_downloader_task(json_file))

    def start_download(self):
        self.worker_threads = self.create_all_downloader_tasks()
        for wt in self.worker_threads:
            wt.start()

    def wait_for_completion_and_stop(self):
        for wt in self.worker_threads:
            wt.join()


if __name__ == '__main__':
    a_sources_dir = Path('./test_resources')
    a_target_dir = Path('./test_resources')

    image_downloader: ImageDownloader = ImageDownloader(a_sources_dir, a_target_dir)
    image_downloader.start_download()
    image_downloader.wait_for_completion_and_stop()
