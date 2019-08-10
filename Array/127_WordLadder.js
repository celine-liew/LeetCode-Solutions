/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    console.log(wordList);
    // if endWord is not word list, return 0
    if (!wordList.includes(endWord)) {
        return 0;
    }
        
    const result = ladderLengthHelper(beginWord, endWord, wordList, 1)
    
    if (result === Number.POSITIVE_INFINITY) {
        return 0;
    }
    
    return result;    
};

const ladderLengthHelper = (beginWord, endWord, wordList, depth) => {
    if (beginWord === endWord) {
        return depth;
    }
    if (wordList.length === 0) {
        return Number.POSITIVE_INFINITY;
    }
    const result = wordList.map((word, idx) => {
        if (oneLetterDiff(beginWord, word)) {
            const newList = wordList.slice();
            newList.splice(idx,1);
            return ladderLengthHelper(word, endWord, newList, depth + 1)
        }
        return Number.POSITIVE_INFINITY;
    });
    
    return Math.min(...result);
}


// return true if same or at most one letter diff
const oneLetterDiff = (a, b) => {
    let oneDiff = false;
    a = a.split('');
    b = b.split('');

    // assume the two parameters are the same size
    for (let i = 0; i < a.length; i++) {
        if (a[i] !== b[i]) {
            if (!oneDiff) {
                oneDiff = true;
            } else {
                return false;
            }
        }
    }
    return true;
}

const beginWord = "qa";
const endWord = "sq";
const wordList = ["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"];

// const beginWord = "hit";
// const endWord = "cog";
// const wordList = ["hot","dot","dog","lot","log","cog"];

console.log(ladderLength(beginWord, endWord, wordList));