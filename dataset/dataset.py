import javalang
import os
import pandas as pd
from tree_reduced import reduce_node

# Pick each algorithm and generate the token report one by one.
# Specify the source folder
source_folder = '''C:\\Users\\Arpan Gupta\\Documents\\Dissertation\\AlgoDetectOptimize\\Database\\Algorithms'''

# Get a list of files in the source folder
file_list = os.listdir(source_folder)

# Defining a DataFrame to store values
df_data = pd.DataFrame(columns=['Algorithm','Method','AST','AAST'])

i = 0
# Loop through the files and create new files with the same names in the destination folder
for filename in file_list:
    i = i+1
    source_file_path = os.path.join(source_folder, filename)

    # Read code from file
    try:
        # Open the file for reading
        with open(source_file_path, 'r') as file:
            # Read the code
            java_code = file.read()
    except FileNotFoundError:
        print(f"File '{source_file_path}' not found.")

    # # Small Sample Java code
    # java_code = """
    # public class MyClass {
    #     int x=5;
    #     void myMethod() {
    #         if (x == 5){
    #             int y = 10;
    #         }
    #     }
    # }
    # """
    print(filename)
    # Parse the code
    tree = javalang.parse.parse(java_code)
    #print('AST\n',tree,'\n')
    atree = reduce_node(tree)
    # Splitting the name to define category
    algo = filename.split('.')
    NM = algo[0].split('_')

    # Temporary storing the data
    data = {
        'Algorithm': NM[0],
        'Method': NM[1],
        'AST': tree,
        'AAST': atree
    }

    # Append the new row
    if df_data.empty:
        df_data.loc[0] = [data['Algorithm'],data['Method'],data['AST'],data['AAST']]
    else:
        df_data = pd.concat([df_data, pd.DataFrame([data])], ignore_index=True)
print(i)
df_data.to_csv('C:\\Users\\Arpan Gupta\\Documents\\Dissertation\\AlgoDetectOptimize\\Database\\Algos.csv', index=False)