* 10 minutes soft discussion
* 40 minutes o flive coding
* Questions I might have



* simulation team
	* Rust for most of the code
		* ML/AI is in Python
		* API in Rust 
		* customer frameworks?
		* 80 people
		* Operating system/runtime
		* Web APIs and running everywhere
			* Internal stuff
			* The product is hardware
	* Data load?
		* telemetry
		* you have video data
		* big team that is working on all of this
	* Flight simulation (which language)
	* air doman
	* leading the team for unmanned fighter jet
* Principal engineer
	* b2b marketplace
* pick different teams
	* ...


def say_hello():
    print('Hello, World')

for i in range(5):
    say_hello()


# fn main() {
#   for n in 0..5 {
#     println!("{} - Hello, World!", n);
#   }
# }

"""
HY-2 Assembly =>(need) Tail Assembly =>(need) M2 Screws <= Avionics Package
Uniqueness of requirement (part ID, quantity) => key of the tree

         HY-2
Fuselage Wings Tail Propulsion


         Propulsion
Motor Brushless




"""

import csv

class TreeNode:

    def __init__(self,assembly_name:str, quantity:int | None = 1):
        self.children:list[TreeNode] = []
        self.assembly_name = assembly_name
        self.quantity = quantity

def build_tree(file_name:str):
    hy2_flattened = {}
    """part_id to node"""
    with open(file_name) as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            assembly = row['ssembly']
            if assembly in hy2_flattened:
                hy2_flattened[assembly].children.append(TreeNode(row['part'],int(row['quantity'])))    
            else:
                hy2_flattened[assembly] = TreeNode(assembly)
                hy2_flattened[assembly].children.append(TreeNode(row['part'],int(row['quantity'])))    

    
    print(hy2_flattened)


if __name__=='__main__':
    build_tree('bill_of_materials.csv')
    







