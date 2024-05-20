def fun(aa, b, *c):
    print(f'a is {aa}')
    print(f'b is {b}')
    print(f'c is {c}')


if __name__ == '__main__':
    quotient, remainder = divmod(20, 8)
    print(quotient, remainder)

    t = (20, 8)
    quotient_t, remainder_t = divmod(*t)
    print(quotient_t, remainder_t)

    a, *other, x, y, z = range(100)
    print(a, x, y, z)

    fun(1, 2, 3, 4, 5, 6, 7, 8, 9)
    fun(*['a', 'b'], 1, 2, 3, 4)
    fun(*['a', 'b'], *(1, 2, 3, 4))

    metro_areas = [
        ('Tokyo', 'JP', 36.933, (35.689722, 139.691667)),
        ('Delhi NCR', 'IN', 21.935, (28.613889, 77.208889)),
        ('Mexico City', 'MX', 20.142, (19.433333, -99.133333)),
        ('New York-Newark', 'US', 20.104, (40.808611, -74.020386)),
        ('São Paulo', 'BR', 19.649, (-23.547778, -46.635833)),
    ]

    for name, code, a_number, (longitude, platitude) in metro_areas:
        print(name)
        print(code)
        print(a_number)
        print(longitude)
        print(platitude)
