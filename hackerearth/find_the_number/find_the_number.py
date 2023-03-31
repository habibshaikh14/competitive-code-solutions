def get_number(block,k,number=0):
    # no of elemts formed if block element is fixed
    fixed_block = block[1:]
    no_of_elements = 1
    for x in fixed_block: no_of_elements*=len(x)
    print(f"No of Elements :: {no_of_elements}")
    # index of fixed arr
    idx = int(k/no_of_elements)
    if k%no_of_elements==0:
         idx -=1
    print(f"Index of Array({idx}) -- {block[0]}\n For {k}th Largest Number is --{block[0][idx]}")
    number = number*10 + int(block[0][idx])
    print(f"Number :: {number}")
    if len(fixed_block)>0:
        return get_number(block[1:],k%no_of_elements,number)
    else:
        return number


def Find_It(x, k, s, n):
    # Write your code here
    from itertools import product
    blocks = [s[i:i+x] for i in range(0, n, x)]
    valid_numbers = []
    new_blocks = [sorted(set(block)) for block in blocks]
    # print(new_blocks)
    return get_number(new_blocks,k)
 
 
N,X,K = 50 ,8, 40001
S = "69859241839387868941176158769631317592843734734832"
 
out_ = Find_It(X, K, S, N)