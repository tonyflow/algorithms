class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val = val
        self.left = left
        self.right = right



def invert_tree(root:TreeNode | None)->TreeNode | None:
    if root is None:
        return root
    
    # Invert subtrees
    root.left = invert_tree(root.left)
    root.right = invert_tree(root.right)

    # Invert current level
    tmp = root.left
    root.left = root.right
    root.right = tmp
    return root