if __name__ == '__main__':
    a_dict = dict(a=1, b=2, c=3, d=4)
    print(a_dict.values())
    print(a_dict.keys())
    for k, v in a_dict.items():
        print(k, v)
