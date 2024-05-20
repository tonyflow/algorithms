def tag(name, *content, class_=None, **attrs):
    """Generate one or more HTML tags"""
    if class_ is not None:
        attrs['class'] = class_
    attr_pairs = (f' {attr}="{value}"' for attr, value in sorted(attrs.items()))
    attr_str = ''.join(attr_pairs)
    if content:
        elements = (f'<{name}{attr_str}>{c}</{name}>' for c in content)
        return '\n'.join(elements)
    else:
        return f'<{name}{attr_str} />'


if __name__ == '__main__':
    """
    One of the best features of Python functions is the extremely flexible parameter handling mechanism. Closely related 
    are the use of * and ** to unpack iterables and mappings into separate arguments when we call a function.
    """
    print(tag('br'))
    print(tag('p', 'hello'))
    print(tag('p', 'hello', 'world'))
    print(tag('p', 'hello', 'world', class_='sidebar'))
    print(tag(content='testing', name="img"))
    my_tag = {
        'name': 'img',
        'title': 'Sunset Boulevard',
        'src': 'sunset.jpg',
        'class': 'framed'
    }
    print(tag(my_tag))

    """
    You can provide keyword ONLY arguments
    
    All arguments to the right of the * are keyword-only. before the *, you may specify other arguments, 
    which work as usual.
    """


    def f(a, *, b):
        return a, b


    print(f(1, b=2))
    try:
        f(1, 2)
    except TypeError:
        print('Invoking the f method without having b as a keyword argument must produce an error')

    """
    You can provide keyword ONLY arguments
    
    All arguments to the left of the / are positional-only. After the /, you may specify other arguments, 
    which work as usual.
    """


    def other_divmod(a, b, /):
        return (a // b, a % b)


    print(other_divmod(3, 4))

    try:
        other_divmod(1, b=5)
    except TypeError:
        print('other_divmod does not accept any keyword arguments')
