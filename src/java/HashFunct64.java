/**
 * mzhash64
 * 
 * Strong, fast, simple, non-cryptographic 64-bit hash function
 * 
 * Author: Matteo Zapparoli
 * Date: 2025-11
 * Reelease: 3
 *
 * SPDX-FileCopyrightText: 2025 Matteo Zapparoli <zapparoli.matteo@gmail.com>
 * SPDX-License-Identifier: Apache-2.0
 * See LICENSE file in project root.
 * 
 */
public class HashFunct64 {

	private HashFunct64() {}

    public static long mzHash64(byte[] data, int start, int length, long seed) {    
        long hash = 0xA7BB53D6328B05DBL ^ seed;
        
        for(int i = 0; i < length; i++)
            hash = 0xCAC39506BB87F535L * (data[start + i] ^ hash ^ (hash << 2) ^ (hash >>> 2));
        
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
		long hash = 0xA7BB53D6328B05DBL ^ seed;
		return 0xCAC39506BB87F535L * (b ^ hash ^ (hash << 2) ^ (hash >>> 2));
	}

	public static long mzHash64(byte b) {
		return 0xCAC39506BB87F535L * (b ^ 0x10B8C87B7405D3C1L);
	}

	public static long mzHash64(short s, long seed) {
	    long hash = 0xA7BB53D6328B05DBL ^ seed;
		
		hash = 0xCAC39506BB87F535L * ((byte)s        ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCAC39506BB87F535L * ((byte)(s >> 8) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static long mzHash64(short s) {
		return mzHash64(s, 0);
	}

	public static long mzHash64(int i, long seed) {
		long hash = 0xA7BB53D6328B05DBL ^ seed;
		
		hash = 0xCAC39506BB87F535L * ((byte)i           ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCAC39506BB87F535L * (((byte)(i >> 8))  ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCAC39506BB87F535L * (((byte)(i >> 16)) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCAC39506BB87F535L * (((byte)(i >> 24)) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static long mzHash64(int i) {
		return mzHash64(i, 0);
	}

	public static long mzHash64(long l, long seed) {
		long hash = 0xA7BB53D6328B05DBL ^ seed;
		
		hash = 0xCAC39506BB87F535L * ((byte)l           ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCAC39506BB87F535L * (((byte)(l >> 8))  ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCAC39506BB87F535L * (((byte)(l >> 16)) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCAC39506BB87F535L * (((byte)(l >> 24)) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCAC39506BB87F535L * (((byte)(l >> 32)) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCAC39506BB87F535L * (((byte)(l >> 40)) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCAC39506BB87F535L * (((byte)(l >> 48)) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		hash = 0xCAC39506BB87F535L * (((byte)(l >> 56)) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		
		return hash;
	}

	public static long mzHash64(long l) {
		return mzHash64(l, 0);
	}

	public static long mzHash64(char c, long seed) {
        long hash = 0xA7BB53D6328B05DBL ^ seed;
        
        hash = 0xCAC39506BB87F535L * ((byte)c        ^ hash ^ (hash << 2) ^ (hash >>> 2));
        hash = 0xCAC39506BB87F535L * ((byte)(c >> 8) ^ hash ^ (hash << 2) ^ (hash >>> 2));
		
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
		return b ? 0x64832685955F7333L : 0x07DCF245E40CB8D1L;
	}

}
