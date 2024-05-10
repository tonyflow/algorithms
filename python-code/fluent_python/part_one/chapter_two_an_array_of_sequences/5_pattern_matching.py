from typing import List, Any, Tuple
from collections import ChainMap as Environment
from typing import TypeVar

Expression = List[str]


class Symbol:
    """
    Dummy class to test class pattern matching
    """

    def __init__(self, x: str):
        self.s: str = x

    def __repr__(self):
        return f'Symbol({self.s})'


# Expression = TypeVar('Expression')
def evaluate(expression: Expression, environment: Environment) -> Any:
    match expression:
        case ['quote', x]:
            return x
        case ['if', test, consequence, alternative]:
            if evaluate(test, environment):
                return evaluate(consequence, environment)
            else:
                return evaluate(alternative, environment)
        case ['lambda', [*params], *body] if body:
            print(f'Identified a lambda expression with params {params} and body {body}')
        case ['define', Symbol() as symbol, value_exp]:
            print(f'Identified a function definition with symbols {str(symbol)} and value expression {value_exp}')
        case ['define', [Symbol() as symbol, *params], *body]:
            print(f'Alternative function definition with symbols {symbol} and others {params} and body {body}')

        case _:
            raise SyntaxError(f'Malformed expression {expression}')


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

    environment = Environment(
        {
            'foo': 'bar'
        }
    )

    evaluate(
        [
            'define',
            [Symbol('function_name'), 'a', 'b', 'c'],
            [
                [
                    'n'
                ],
                [
                    '*', 'n', 2
                ]
            ]
        ],
        environment
    )

    evaluate(
        [
            'define',
            Symbol('double'),
            [
                'lambda',
                [
                    'n'
                ],
                [
                    '*', 'n', 2
                ]
            ]
        ], environment)

    evaluate(
        [
            'lambda',
            ['x'],
            ['*', 'x', 2]], environment
    )
