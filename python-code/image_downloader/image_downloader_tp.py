import json
import os
from multiprocessing.pool import ThreadPool
from pathlib import Path
from threading import get_ident

import requests


class ImageDownloaderThreadPool:
    """
    Dummy image downloader. This was a coding challenge in one the Scandit interviews
    """

    def __init__(self,
                 sources_dir: Path,
                 target_dir: Path,
                 number_of_workers: int = 10):
        self.sources_dir: Path = sources_dir
        self.target_dir: Path = target_dir
        self.number_of_workers = number_of_workers

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
                print(f'[thread_id: {get_ident()}] {json_file} is empty. Skipping processing')

    def download(self):
        with ThreadPool(self.number_of_workers) as pool:
            pool.map(self.create_single_downloader_task, self.sources_dir.glob('**/*.json'))


if __name__ == '__main__':
    a_sources_dir = Path('./test_resources')
    a_target_dir = Path('./test_resources')

    image_downloader: ImageDownloaderThreadPool = ImageDownloaderThreadPool(a_sources_dir, a_target_dir)
    image_downloader.download()
