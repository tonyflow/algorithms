if __name__ == '__main__':
    colors = ['black', 'white']
    sizes = ['S', 'M', 'L']
    t_shirts = [(color,size) for color in colors for size in sizes]
    t_shirts_2 = [(size, color) for color in colors for size in sizes]
    print(t_shirts)
    print(t_shirts_2)