const removeInvalidParentheses = require('./301_remove_invalid_parentheses');

const testCases = [
    {
        input: "()())()",
        ans: ["()()()", "(())()"]
    },
    {
        input: "(a)())()",
        ans: ["(a)()()", "(a())()"]
    },
    {
        input: ")(",
        ans: [""]
    },
    {
        input: "(((()",
        ans: ["()"]
    },
    {
        input: ")((()(())((((",
        ans: ["()(())"]
    },
]

testCases.forEach(testCase => {
    test(testCase.input.toString(), () => {
        expect(testCase.ans.includes(removeInvalidParentheses(testCase.input))).toBeTruthy();
    })
});