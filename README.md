# mzHash64

Strong, fast, simple, non-cryptography hash function

```java
public static long mzHash64(byte[] data, int start, int length, long seed) {	
	long hash = 0xD45E69F901E72147L ^ seed;

	for(int i = 0; i < length; i++)
		hash = 0x3631754B22FF2D5CL * (i + data[start + i]) ^ (hash << 2) ^ (hash >>> 2);

	return hash;
}
```
It is based on the same algorithm as [mzHash32](https://github.com/matteo65/mzHash32), except it uses 64-bit (long) integers.

## Uniform distribution of hash values (diffusion)
It has an absolutely uniform, chaotic distribution of hash values independent of the number, length and type of input values.  
It also has a good Avalanche Effect property: even a minimal differences (1 bit) of input values produces very different hash values.  
This is the screenshot of the VisualRT app related to the analysis of the file words_and_numbers.txt.mzhash64 which contains the hashes of all the words contained in the file words_and_numbers.txt  
![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash64/main/Resource/visualrt_screenshot.png)  
The analysis does not indicate the presence of any statistical anomaly and therefore the file can be considered random, demonstrating the goodness of the distribution of the hash values.  

## Minimum number of collisions
MzHash64 produces a very low number of collisions for each reasonably large number of distinct values; it is close to the collisions number of an ideal Universal Hash Function.

#### Number of collisions for data input string "sssss", where s from "000000000" to "2540BE3FF" - 10,000,000,000 values (expected 2.71 collisions)

Function |  #Collisions | Values
:---      |      ---:    | :---
MzHash64  |         **0**|&nbsp;
Murmur3   |         **5**|Collision: **45 F0 06 CF E1 6F F4 D7**<br>Strings: "07AF2BABB07AF2BABB07AF2BABB07AF2BABB07AF2BABB", "184D0B97E184D0B97E184D0B97E184D0B97E184D0B97E"
 &nbsp;   |     &nbsp;   |Collision: **88 B9 B4 F8 9A EF 0B 0D**<br>Strings: "1C60B95911C60B95911C60B95911C60B95911C60B9591", "1F3A5D9AE1F3A5D9AE1F3A5D9AE1F3A5D9AE1F3A5D9AE"
 &nbsp;   |     &nbsp;   |Collision: **B1 B2 60 25 7D 9C DF 95**<br>Strings: "0E152D31E0E152D31E0E152D31E0E152D31E0E152D31E", "181B53CCC181B53CCC181B53CCC181B53CCC181B53CCC"
 &nbsp;   |     &nbsp;   |Collision: **D3 ED E1 23 5C 9A 41 D4**<br>Strings: "05C06C20B05C06C20B05C06C20B05C06C20B05C06C20B", "131D7411C131D7411C131D7411C131D7411C131D7411C"
 &nbsp;   |     &nbsp;   |Collision: **EA 2F 63 5A 7B 41 EF 22**<br>Strings: "1A89ECD471A89ECD471A89ECD471A89ECD471A89ECD47", "24F1BB43A24F1BB43A24F1BB43A24F1BB43A24F1BB43A"
 XXHash   |         **3**|Collision: **73 5A C8 30 AC 14 DA 27**<br>Strings: "101570C93101570C93101570C93101570C93101570C93", "17F255DF617F255DF617F255DF617F255DF617F255DF6"
 &nbsp;   |     &nbsp;   |Collision: **7E 7B E5 32 95 6E CC C8**<br>Strings: "05652E7A205652E7A205652E7A205652E7A205652E7A2", "179BFA274179BFA274179BFA274179BFA274179BFA274"
 &nbsp;   |     &nbsp;   |Collision: **C3 DC 2E 55 5B F3 82 A0**<br>Strings: "003AA63E8003AA63E8003AA63E8003AA63E8003AA63E8", "1AB1E788D1AB1E788D1AB1E788D1AB1E788D1AB1E788D"
 
 #### Number of collisions for 30 byte input bbbbbb, where b from 00 00 00 00 00 to 02 54 0B E3 FF - 10,000,000,000 values (expected 2.71 collisions)
Function|  #Collisions| Values
:---    |      ---:   | :---
MzHash64|        **0**|&nbsp;
Murmur3 |        **1**|Collision: **7A 37 28 87 4D A9 F8 1E**<br>Inputs: 023D8B9FEC 023D8B9FEC 023D8B9FEC 023D8B9FEC 023D8B9FEC 023D8B9FEC, 0249F3C8FF 0249F3C8FF 0249F3C8FF 0249F3C8FF 0249F3C8FF 0249F3C8FF
XXHash  |        **1**|Collision: **50 70 7F C1 20 21 83 0E**<br>Inputs: 010F132BC9 010F132BC9 010F132BC9 010F132BC9 010F132BC9 010F132BC9, 01B215C6D7 01B215C6D7 01B215C6D7 01B215C6D7 01B215C6D7 01B215C6D7

## Speed
![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash64/main/Resource/mzhash64speed.jpg)

## Vulnerability
MzHash64, like most non-cryptographic functions, is non-secure because it is not specifically designed to be difficult to reverse by an adversary, making it unsuitable for cryptographic purposes. Its use is instead recommended in all other contexts where hash functions are used.  
Like other non-cryptographic functions, its security depends on the secrecy of the possibly used seed.  

## Portability
It is minimalist, elegant, straightforward and can be easily written in virtually any programming language. 
Currently C and Java versions are available.

## Conclusion
MzHash64 demonstrates to have an excellet quality of the dispersion, close to an ideal Universal Hash Function. It is simple, portable and produces same results in all platform. On the other hand it is slower than XX and Murmur3. If the goal is the quality of the dispersion and have the same result on all platforms, mzHash64 is certainly the function to choose!

