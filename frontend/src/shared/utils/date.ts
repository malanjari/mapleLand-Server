/**
 * UTC 시간을 한국 시간(KST)으로 변환하는 유틸리티 함수
 * @param dateString - 변환할 날짜 문자열
 * @returns 한국 시간으로 변환된 Date 객체
 */
export const convertToKoreaTime = (dateString: string): Date => {
  const date = new Date(dateString);
  return new Date(date.getTime() + 32390000);
};

/**
 * UTC 시간을 KST(+9시간)로 변환하는 유틸리티 함수
 * @param dateString - 변환할 날짜 문자열
 * @returns KST 시간으로 변환된 Date 객체
 */
export const convertToKST = (dateString: string): Date => {
  const date = new Date(dateString);
  return new Date(date.getTime() + 9 * 60 * 60 * 1000);
};
