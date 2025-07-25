export const isSubsequence = (small: string, big: string) => {
  let i = 0;
  for (let j = 0; j < big.length; j++) {
    if (small[i] === big[j]) i++;
    if (i === small.length) return true;
  }
  return false;
};
