from typing import List, Any, Tuple


def handle_message(message: List[Any]) -> str:
    match message:
        case ['BEEPER', frequency, time as t]:
            return f'foo with frequency {frequency} and time {time}'
        case ['LED', indent, intensity]:
            return 'led'
        case _:
            raise OSError('Invalid Command')


def metro_match(d: Tuple[str, str, float, Tuple[float, float]]):
    match d:
        case [*_, (longitude, platitude) as coordinates] if longitude > 30:
        # case [_, _, _, (longitude, platitude) as coordinates] if longitude > 30:
            print(coordinates)


if __name__ == '__main__':
    print(handle_message(['BEEPER', 34, 45]))
    metro_areas = [
        ('Tokyo', 'JP', 36.933, (35.689722, 139.691667)),
        ('Delhi NCR', 'IN', 21.935, (28.613889, 77.208889)),
        ('Mexico City', 'MX', 20.142, (19.433333, -99.133333)),
        ('New York-Newark', 'US', 20.104, (40.808611, -74.020386)),
        ('São Paulo', 'BR', 19.649, (-23.547778, -46.635833)),
    ]

    for m_data in metro_areas:
        metro_match(m_data)
