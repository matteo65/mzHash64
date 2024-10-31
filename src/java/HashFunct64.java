/**
 * mzHash64
 * 
 * Strong, fast, simple, non-cryptographic 34-bit hash function
 * 
 * Author: Matteo Zapparoli
 * Date: 2022
 * Licence: Public Domain
 * 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 * 
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 * 
 * For more information, please refer to <https://unlicense.org>
 * 
 */
public class HashFunct64 {

	private HashFunct64() {}

		public static long mzHash64(byte[] data, int start, int length, long seed) {	
		long hash = 0xE297DA430DB2DF1AL ^ seed;
		
		for(int i = 0; i < length; i++)
			hash = 0xB2DEEF07CB4ACD43L * (i + data[start + i]) ^ (hash << 2) ^ (hash >>> 2);
		
		return hash;
	}
	
	public static long mzHash64(byte[] data, int start, int length) {
		return mzHash64(data, start, length, 0);
	}
	
	public static long mzHash64(byte[] data) {
		return mzHash64(data, 0, data.length, 0);
	}
	
	public static long mzHash64(byte[] data, long seed) {	
		return mzHash64(data, 0, data.length, seed);
	}
	
	public static long mzHash64(byte b, long seed) {
		long hash = 0xE297DA430DB2DF1AL ^ seed;
		return 0xB2DEEF07CB4ACD43L * b ^ (hash << 2) ^ (hash >>> 2);
	}
	
	public static long mzHash64(byte b) {
		return 0xB2DEEF07CB4ACD43L * b ^ 0xB2FA9F9CF5A7CBAEL;
	}
	
	public static long mzHash64(short s, long seed) {
		long hash = 0xE297DA430DB2DF1AL ^ seed;
		
		hash = 0xB2DEEF07CB4ACD43L * (byte)s ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xB2DEEF07CB4ACD43L * (1 + (byte)(s >> 8)) ^ (hash << 2) ^ (hash >>> 2);
		
		return hash;
	}
	
	public static long mzHash64(short s) {
		return mzHash64(s, 0);
	}
	
	public static long mzHash64(int i, long seed) {
		long hash = 0xE297DA430DB2DF1AL ^ seed;
		
		hash = 0xB2DEEF07CB4ACD43L * (byte)i ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xB2DEEF07CB4ACD43L * (1 + (byte)(i >> 8)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xB2DEEF07CB4ACD43L * (2 + (byte)(i >> 16)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xB2DEEF07CB4ACD43L * (3 + (byte)(i >> 24)) ^ (hash << 2) ^ (hash >>> 2);
		
		return hash;
	}
	
	public static long mzHash64(int i) {
		return mzHash64(i, 0);
	}
	
	public static long mzHash64(long l, long seed) {
		long hash = 0xE297DA430DB2DF1AL ^ seed;
		
		hash = 0xB2DEEF07CB4ACD43L * (byte)l ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xB2DEEF07CB4ACD43L * (1 + (byte)(l >> 8)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xB2DEEF07CB4ACD43L * (2 + (byte)(l >> 16)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xB2DEEF07CB4ACD43L * (3 + (byte)(l >> 24)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xB2DEEF07CB4ACD43L * (4 + (byte)(l >> 32)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xB2DEEF07CB4ACD43L * (5 + (byte)(l >> 40)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xB2DEEF07CB4ACD43L * (6 + (byte)(l >> 48)) ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xB2DEEF07CB4ACD43L * (7 + (byte)(l >> 56)) ^ (hash << 2) ^ (hash >>> 2);
		
		return hash;
	}
	
	public static long mzHash64(long l) {
		return mzHash64(l, 0);
	}
	
	public static long mzHash64(char c, long seed) {
		long hash = 0xE297DA430DB2DF1AL ^ seed;
		
		hash = 0xB2DEEF07CB4ACD43L * (byte)c ^ (hash << 2) ^ (hash >>> 2);
		hash = 0xB2DEEF07CB4ACD43L * (1 + (byte)(c >> 8)) ^ (hash << 2) ^ (hash >>> 2);
		
		return hash;
	}
	
	public static long mzHash64(char c) {
		return mzHash64(c, 0);
	}
	
	public static long mzHashlong(String str, long seed) {
		return mzHash64(str.getBytes(), seed);
	}
	
	public static long mzHashlong(String str) {
		return mzHash64(str.getBytes(), 0);
	}
	
	public static long mzHash64(boolean b, long seed) {
		return b ? mzHash64(1, seed) : mzHash64(0, seed);
	}
	
	public static long mzHash64(boolean b) {
		return b ? 0x3843B561F5BE46C4L : 0x8AFF08F1E7D9BB61L;
	}

}

