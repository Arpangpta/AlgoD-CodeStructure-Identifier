import javalang

# code = """
# public class MyClass {
#     int myVar = 42;
#     double x0;
#     public void myMethod(int x, double y, int z) {
#         if (x == myVar/2 && y!=x0){
#             return myVar;
#         } else {
#             self.myMethod(x,y,42);
#         }
#     }
# }
# """

# tree = javalang.parse.parse(code) 
# print('Original AST\n',str(tree))

def reduce_node(node):
    if node.__class__ is list:
        d =  list( map( reduce_node, node))
        return d    
    d = {}
    attrs = [attr for attr in dir(node) if 
                not attr.startswith('__') and 
                not attr=='_position' and 
                not attr=='declarators' and
                not attr=='modifiers' #and
             ]

    i = 1
    for attr in attrs:
        val = None

        try:
            attr in node.__dict__
        except AttributeError:
            continue

    
        if attr in node.__dict__:
            if (node.__dict__[attr]!=None and node.__dict__[attr]!=[] and node.__dict__[attr]!={}):
                if node.__dict__[attr].__class__ is list:
                    if attr=='parameters':                        
                        pars = [ par.type for par in  node.__dict__[attr] ]
                        #print('Pars',pars)
                        val = [ reduce_node(n) for n in pars ] 
                    else:
                        val = [ reduce_node(n) for n in  node.__dict__[attr]  ]
                elif isinstance(node.__dict__[attr],object) and issubclass(node.__dict__[attr].__class__,javalang.ast.Node):
                    val =   reduce_node(node.__dict__[attr])
                else:
                    val = node.__dict__[attr]
        if val != None and val!=[] and val!={}:
            if attr == 'type':
                if isinstance(val,str):     
                    d[attr] = val         
                else:                       
                    d[attr]=val['name']
            elif attr!='member' and attr !='qualifier':
                d[attr]=val


    return d


# node_reduced = reduce_node(tree)
# print('\nPartially refractored AST by me\n',(node_reduced))
