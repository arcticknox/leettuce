
const swap = (inputArr, x, y) => {
    const temp = inputArr[x];
    inputArr[x] = inputArr[y];
    inputArr[y] = temp;
}

const bubbleSort = () => {
    let inputArr = [3,4,51,98,45,23,78,1];
    for (let i = 0; i < inputArr.length - 1; i++) {
        for (let j = 0; j < inputArr.length - i - 1; j++) {
            if (inputArr[j] > inputArr[j + 1]) {
                swap(inputArr, j, j + 1)
            }
        }
    }
    return inputArr;
}

// Work (Swap) then solve (Reduce) - Head tail partition
const insertionSort = () => {
    let inputArr = [3,4,51,98,45,23,78,1];
    for (let i = 1; i < inputArr.length; i++) {
        let j = i;
        while (j > 0 && inputArr[j] < inputArr[j-1]) {
            swap(inputArr, j, j - 1); // Work
            j--;
        }
    }
    return inputArr;
}

// Solve then work - slice
const shellSort = () => {
    let inputArr = [3, 4, 51, 98, 45, 23, 78, 1];
    let h = 1;
    while (h < inputArr.length / 3) h = h * 3 + 1;
    while (h >= 1) {
      for (let i = h; i < inputArr.length; i++) {
        for (let j = i; j >= h && inputArr[j - h] < inputArr[j]; j -= h) {
          swap(inputArr, j, j-h) // work
        }
      }
      h = Math.floor(h / 3);
    }
    return inputArr;
  };

// Work then solve - Head tail partition
const selectionSort = () => {
    let inputArr = [3, 4, 51, 98, 45, 23, 78, 1];
    const n = inputArr.length;
    for (let i = 0; i < n; i++) {
        let min = i;
        for (let j = i + 1; j < n; j++) {
            if (inputArr[j] < inputArr[min]) {
                min = j;
            }
        }
        swap(inputArr, i, min) // work
    }
    return inputArr;
}
// console.log(bubbleSort())
// console.log(insertionSort())
console.log(selectionSort())