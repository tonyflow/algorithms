from csv import DictReader


def parse_csv(file_path: str):
    with open(file_path) as csv_file:
        reader = DictReader(csv_file, delimiter=',')

        for row in reader:
            print(row)


if __name__ == '__main__':
    parse_csv('./test_file.csv')
