// Sneha and the Gossip-Free Library
//
// Problem Statement:
// Sneha is trying to find the quietest seats in the library.
//
// The library is represented as an N x N matrix:
// 1 -> Occupied seat
// 0 -> Empty seat
//
// Mark the seats as:
// O -> Occupied seat
// X -> Disturbed seat (adjacent to occupied seat)
// S -> Safe empty seat
//
// A seat becomes disturbed if at least one of its
// top, bottom, left, or right neighbors is occupied.
//
// Input Format:
// First line contains integer N
// Next N lines contain N space-separated integers
//
// Output Format:
// Print the final seating matrix.

import java.util.*;

public class Main {

    static boolean valid(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        char[][] ans = new char[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();
                ans[i][j] = (arr[i][j] == 1) ? 'O' : 'S';
            }
        }

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {

                if(arr[i][j] == 1) {

                    for(int k=0;k<4;k++) {

                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if(valid(nr,nc,n) && arr[nr][nc] == 0) {
                            ans[nr][nc] = 'X';
                        }
                    }
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
