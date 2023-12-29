1.  HashMap is not thread safe
    - Very fast performance


2.  HashTable is thread safe -
    - The whole map is synchronized.
    - It takes a lock over whole map.
    - All the methods are synchronized.
    - Performance is very slow


3.  Concurrent HashMap
    - Thread safe version of hash map
    - Does not take lock on all the keys but takes only on a set of keys (bucket).
    - How it creates buckets - based on sorting order, access patterns
      ex. B1 {a, b, c}, B2 = {d, e, f, g}
      If T1 -> a and T2 -> b - Not possible as in same bucket
      If T1 -> a and T2 -> d - Yes they can access parallel as different buckets

    - performance better than HashTable but not as good as HashMap


4.  Why not create lock on all the keys?
    - Maps can have thousands of keys. Not memory efficient if we create lock for each key.


5. - String is immutable data structure and hence thread safe and very slow.
   - As String was slow StringBuilder and StringBuffer was introduced. Both are mutable.
   - StringBuilder - not thread safe  
   - StringBuffer - thread safe
   - Performance - String < StringBuffer < StringBuilder (low - medium - fast)


6.  What is default size of bucket on concurrentHashMap?
    - 64 by default


