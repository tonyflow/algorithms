from array import array

if __name__ == '__main__':
    test_byte_r: bytes = bytes('\t', encoding='utf_8')
    test_r_a = b'test_r'
    print(test_byte_r[0])
    print(test_r_a)

    """
    Creating a bytes or bytearray object from any buffer-like source will always copy the bytes.
    In contrast, memoryview objects lets you share memory resources from binary data objects
    """
    numbers = array('h', [-1, 0, 1, 4, 5, 6])
    print(bytes(numbers))

    """
    Encoders/Decoders: Worth scanning pages 154 on wards from the original book. 
    This is a very nuanced topic.
    
    Important: Figuring out the encoding of a byte sequence is not possible. One can either be told
    of have a try catch on multiple decoders
    """

    with open('test_resources/test_file.txt', mode='r', encoding='utf_8') as f:
        for line in f.readlines():
            print(line)

    with open('test_resources/write_output.txt', mode='w', encoding='utf_8') as f:
        f.write('let me test this')

    with open('test_resources/write_output.txt', mode='r') as f:
        for line in f.readlines():
            print(line)

    """
    Unicode normalization is too nuanced to mention some key points here. For more information
    check page 170 onwards on the book. 
    """
