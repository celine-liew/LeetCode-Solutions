module.exports = removeInvalidParentheses = (s) => {
    const stack = [];
    let position = 0;

    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) === '(') {
            stack.push(['(', position])
        } else if (s.charAt(i) === ')') {
            if (stack[stack.length-1] && stack[stack.length - 1][0] === '(') {
                stack.pop();
                position += 2;
            } else {
                stack.push([')', position])
            }
        } else {
            position++;
        }
    }

    stack.forEach(toRemove => {
        s = s.substring(0, toRemove[1]) + s.substring(toRemove[1] + 1);
    });
    return s;
};