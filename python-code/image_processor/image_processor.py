from PIL import Image
from pathlib import Path


# TODO finish this
class ImageProcessor:
    def __init__(self, input_dir: str):
        self.directory: Path = Path(input_dir)

    def load(self):
        for image in self.directory.glob("**/*.jpg"):
            Image.open(image)
