from array import array

if __name__ == '__main__':
    # symbols = '$¢£¥€¤'
    # t = tuple(ord(s) for s in symbols)
    # print(t)

    """
    The array constructor takes two arguments, so the parentheses around
    the generator expression are mandatory. The first argument of the array
    constructor defines the storage type used for the numbers in the array
    """
    # r = array('I', t)

    colors = ['black', 'white']
    sizes = ['S', 'M', 'L']
    t_shirt_generator = (f'{s} {c}' for c in colors for s in sizes)
    for t in t_shirt_generator:
        print(t)
