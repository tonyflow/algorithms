import tkinter as tk


def on_button_click():
    print('Button clicked')


if __name__ == '__main__':
    root = tk.Tk()
    button = tk.Button(root, text='Click me', command=on_button_click)
    button.pack()
    root.mainloop()
