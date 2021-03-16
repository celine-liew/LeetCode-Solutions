# 146
# uses ordered Dict
# Underlying implementation = doubly linked list
# python 3.6 onwards ordered, uses dense (key value) & sparse arrrays (stores indices to dense arrays)
# difference of ordered Dict. Has 2 additional functions: `reversed` & `move_to_end`.
class LRUCache():

    def __init__(self, capacity: int):
        self.dict = collections.OrderedDict()
        self.cpacity = capacity
        

    def get(self, key: int) -> int:
        if key not in self.dict:
            return -1
        self.dict.move_to_end(key) # makes it LRU
        return self.dict[key]
        

    def put(self, key: int, value: int) -> None:
        if key in self.dict:
            self.dict.move_to_end(key)
        self.dict[key] = value
        if len(self.dict) > self.cpacity:
            self.dict.popitem(False)
    
    def deleteFirst(self) -> None:
        self.dict.popitem(False)

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

# Using doubly-linked list & hashmap implemetation:
class secondLRUCache():

    def __init__(self, capacity: int):


    def get(self, key: int) -> int:


    def put(self, key: int, value: int) -> None:

    
    def deleteFirst(self) -> None:
