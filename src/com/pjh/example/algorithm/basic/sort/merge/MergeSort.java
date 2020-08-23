package com.pjh.example.algorithm.basic.sort.merge;

/**
 *  정렬된 2개의 array를 처음 값을 비교하여 결과 배열에 저장한다
 *  공간을 사용하지 못하는 상황에는 적합하지 못함
 */
public class MergeSort {

    private static void mergeSort(int[] arr){
        // 임시 저장공간
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    /**
     * @param arr  정렬 배열
     * @param tmp 임시저장공간
     * @param start 시작 index
     * @param end 끝 index
     */
    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        // 시작 index가 작을때
        if(start < end){
            //시작시 가운데로 잘라야함
            int mid = (start + end) / 2;

            //merge 왼쪽 array, 오른쪽 array sort
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);

            //2개로 나뉜 배열방을 merge
            merge(arr, tmp, start, mid, end);
        }

    }

    /**
     * @param arr 정렬할 배열
     * @param tmp 임시저장공간
     * @param start 시작 index
     * @param mid 중간 index
     * @param end 끝 index
     */
    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        //임시저장소 복사
        for(int i = start; i <= end; i++){
            tmp[i] = arr[i];
        }
        // 2개의 배열이 중간 지점을 기준으로 하나로 붙어있어 각 첫번째 index
        int part1 = start;
        int part2 = mid + 1;
        // 결과 배열방 저장 point
        int index = start;

        //첫번째 array 끝까지, 두번째 array 끝까지
        while(part1 <= mid && part2 <= end){

            //값 비교하여 작은값 복사 후 point 이동
            if(tmp[part1] <= tmp[part2]){
               arr[index] = tmp[part1];
               part1++;
            }else{
                arr[index] = tmp[part2];
                part2++;
            }
            //결과 index 이동
            index++;

            //part1, 2 중에 하나가 끝나서 다른 array의 데이터가 남아있는 경우
            //뒤쪽배열은 어차피 뒤에 남아있는 거니까 앞쪽 배열만 체크하면됌
            for(int i = 0; i <= mid - part1; i++){
                arr[index + i] = tmp[part1 + i];
            }
        }
    }

    private static void printArray(int[] arr){
        for(int data : arr){
            System.out.print(data + ", ");
        }
        System.out.println();
    }
    public static void main(final String[] args){
        int[] arr = {3, 4, 6, 7, 2, 1, 8, 9, 0};
        //int[] arr = {3, 3, 1, 1, 2, 2, 5, 5};
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }
}
