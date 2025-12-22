package BinarySearch;

public class SearchRotatedArrayII {

    // Optimized: handles duplicates
    public static boolean searchRotatedIIOpt(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;

            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
            } else if (arr[left] <= arr[mid]) { // left half sorted
                if (target >= arr[left] && target < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else { // right half sorted
                if (target > arr[mid] && target <= arr[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(searchRotatedIIOpt(a, 0) ? "Found" : "Not Found");
        System.out.println(searchRotatedIIOpt(a, 3) ? "Found" : "Not Found");
    }
}
