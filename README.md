# XURL
# Introduction
XURL is a utility that can be used to generate and retrieve short URLs when we don’t want to use the original longer URLs.



# Scope of Work
Create a concrete class which implements a short URL interface class provided. It contains all the methods that can be used to create long URL to short URL mappings.

Implement a method to take a long URL as input, generate a random 9 character short URL and return it. Also maintain this mapping using a hash map for quick retrieval.

Implement a method to take a long URL and a custom short URL as input and register that mapping. 

Error handling to make sure each long URL maps to only one short URL and vice versa.

Implement a method to lookup short URL for a given long URL, from the mapping created.

Implement a method to delete the mapping based on a long URL.

Implement a counter to keep track of the hit count for each long URL - which tells us how many times a particular long URL has been looked up.
Test these methods using test cases.
## Tech Stack

**Skill used:** Core Java, Interfaces, Debugging

