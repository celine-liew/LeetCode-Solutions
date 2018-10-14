## Given nums = [2, 7, 11, 15], target = 9,
## Because nums[0] + nums[1] = 2 + 7 = 9,
## return [0, 1]

def loop (nums, target):
    for idx1, i in enumerate(nums):
        for idx2, j in enumerate(nums[idx1+1:]):
            if i+j == target:
                return [idx1, idx1+1+idx2]

def loop1 (nums, target):
    for i in range(len(nums)):
        for j in range(i+1, len(nums)):
            if nums[i] + nums[j] == target:
                return [i, j]

def map (nums, target):
   map = dict()
   for idx, num in enumerate(nums):
       difference = target - num
       if difference in map:
           return [map[difference], idx]
       map[num] = idx 

nums = [2, 7, 11, 15]
target = 26

print(loop(nums, target))
print(loop1(nums, target))
print(map(nums, target))