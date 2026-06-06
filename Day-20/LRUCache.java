/*
Problem Statement:
Shreya was building a smart attendance portal for her college.
To improve response time, the system stored recently accessed student records in a cache.
However, the cache had limited capacity.

Whenever the cache became full and a new record needed to be added,
the least recently used (LRU) record was automatically removed from the cache.

Your task is to implement this smart cache system and process a series of operations.

Input Format:
The first line contains an integer Capacity — the maximum number of records the cache can store.
The second line contains an integer Q — the number of operations.

The next Q lines contain one of the following operations:
PUT key value — Insert or update a record in the cache.
GET key — Retrieve the value associated with the given key.

Output Format:
For every GET operation:
Print the corresponding value if the key exists in the cache.
Otherwise, print -1.

Example:
Input:
2
5
PUT 1 10
PUT 2 20
GET 1
PUT 3 30
GET 2

Output:
10
-1
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int capa = sc.nextInt();
        int q = sc.nextInt();

        LinkedHashMap<Integer, Integer> cache =
                new LinkedHashMap<Integer, Integer>(capa, 0.75f, true) {
                    @Override
                    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                        return size() > capa;
                    }
                };

        for (int i = 0; i < q; i++) {
            String op = sc.next();

            if (op.equals("PUT")) {
                int key = sc.nextInt();
                int val = sc.nextInt();
                cache.put(key, val);
            } else if (op.equals("GET")) {
                int key = sc.nextInt();
                System.out.println(cache.getOrDefault(key, -1));
            }
        }

        sc.close();
    }
}
