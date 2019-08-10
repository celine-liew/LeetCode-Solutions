const permute = require('./46_permutations');

const testCases = [
    {
        input: [1,2,3],
        ans: [
                [1,2,3],
                [1,3,2],
                [2,1,3],
                [2,3,1],
                [3,1,2],
                [3,2,1]
            ]
    }
]

testCases.forEach(testCase => {
    test(testCase.input.toString(), () => {
        expect(permute(testCase.input)).toEqual(testCase.ans);
    })
});