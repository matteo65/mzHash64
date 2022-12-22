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
## Uniform distribution of hash values (diffusion)
It has an absolutely uniform, chaotic distribution of hash values independent of the number, length and type of input values.  
It also has a good Avalanche Effect property: even a minimal differences (1 bit) of input values produces very different hash values.  

## Minimum number of collisions
MzHash64 produces a very low number of collisions for each reasonably large number of distinct values; it is close to the collisions number of a Universal Hash Function.

#### Number of collisions for data input string "sssss", where s from "000000000" to "2540BE3FF". 10,000,000,000 values

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
 
 #### Number of collisions for 30 byte input bbbbbb, where b from 00 00 00 00 00 to 02 54 0B E3 FF. 10,000,000,000 values
 Function |  #Collisions | Values
:---      |      ---:    | :---
MzHash64  |         **0**|&nbsp;
Murmur3   |         **6**|Collision: **20 1C 0D A0 FC 75 6B 82**<br>Inputs: 018100AFA4018100AFA4018100AFA4018100AFA4018100AFA4008100AFA4, 01B06B986F01B06B986F01B06B986F01B06B986F01B06B986F00B06B986F

