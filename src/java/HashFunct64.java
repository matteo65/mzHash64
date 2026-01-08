/**
 * mzhash64
 * 
 * Strong, fast, simple, non-cryptographic 64-bit hash function
 * 
 * Author: Matteo Zapparoli
 * Date: 2026-01
 * Reelease: 5
 *
 * SPDX-FileCopyrightText: 2026 Matteo Zapparoli <zapparoli.matteo@gmail.com>
 * SPDX-License-Identifier: Apache-2.0
 * See LICENSE file in project root.
 * 
 */
public class HashFunct64 {

	private HashFunct64() {}

    public static long mzHash64(byte[] data, int start, int length, long seed) {    
        long hash = 0xFA3BE25AB0E56E7FL ^ seed;
        
        for(int i = 0; i < length; i++)
            hash = 0x364BD2EE336025ABL * (data[start + i] ^ (hash << 1) ^ (hash >>> 1));
        
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
		long hash = 0xFA3BE25AB0E56E7FL ^ seed;
		return 0x364BD2EE336025ABL * (b ^ (hash << 1) ^ (hash >>> 1));
	}

	public static long mzHash64(byte b) {
		return 0x364BD2EE336025ABL * (b ^ 0x896A359839B86BC1L);
	}

	public static long mzHash64(short s, long seed) {
	    long hash = 0xFA3BE25AB0E56E7FL ^ seed;
		
		hash = 0x364BD2EE336025ABL * ((byte)s        ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x364BD2EE336025ABL * ((byte)(s >> 8) ^ (hash << 1) ^ (hash >>> 1));
		
		return hash;
	}

	public static long mzHash64(short s) {   
        long hash = 0x364BD2EE336025ABL * ((byte)s ^ 0x896A359839B86BC1L);
        hash = 0x364BD2EE336025ABL * ((byte)(s >> 8) ^ (hash << 1) ^ (hash >>> 1));
        
        return hash;
	}

	public static long mzHash64(int i, long seed) {
		long hash = 0xFA3BE25AB0E56E7FL ^ seed;
		
		hash = 0x364BD2EE336025ABL * ((byte)i         ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x364BD2EE336025ABL * ((byte)(i >> 8)  ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x364BD2EE336025ABL * ((byte)(i >> 16) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x364BD2EE336025ABL * ((byte)(i >> 24) ^ (hash << 1) ^ (hash >>> 1));
		
		return hash;
	}

	public static long mzHash64(int i) {
        long hash = 0x364BD2EE336025ABL * ((byte)i ^ 0x896A359839B86BC1L);
        hash = 0x364BD2EE336025ABL * ((byte)(i >> 8)  ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x364BD2EE336025ABL * ((byte)(i >> 16) ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x364BD2EE336025ABL * ((byte)(i >> 24) ^ (hash << 1) ^ (hash >>> 1));
        
        return hash;
	}

	public static long mzHash64(long l, long seed) {
		long hash = 0xFA3BE25AB0E56E7FL ^ seed;
		
		hash = 0x364BD2EE336025ABL * ((byte)l         ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x364BD2EE336025ABL * ((byte)(l >> 8)  ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x364BD2EE336025ABL * ((byte)(l >> 16) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x364BD2EE336025ABL * ((byte)(l >> 24) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x364BD2EE336025ABL * ((byte)(l >> 32) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x364BD2EE336025ABL * ((byte)(l >> 40) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x364BD2EE336025ABL * ((byte)(l >> 48) ^ (hash << 1) ^ (hash >>> 1));
		hash = 0x364BD2EE336025ABL * ((byte)(l >> 56) ^ (hash << 1) ^ (hash >>> 1));
		
		return hash;
	}

	public static long mzHash64(long l) {
        long hash = 0x364BD2EE336025ABL * ((byte)l ^ 0x896A359839B86BC1L);
        hash = 0x364BD2EE336025ABL * ((byte)(l >> 8)  ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x364BD2EE336025ABL * ((byte)(l >> 16) ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x364BD2EE336025ABL * ((byte)(l >> 24) ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x364BD2EE336025ABL * ((byte)(l >> 32) ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x364BD2EE336025ABL * ((byte)(l >> 40) ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x364BD2EE336025ABL * ((byte)(l >> 48) ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x364BD2EE336025ABL * ((byte)(l >> 56) ^ (hash << 1) ^ (hash >>> 1));
        
        return hash;
	}

	public static long mzHash64(char c, long seed) {
        long hash = 0xFA3BE25AB0E56E7FL ^ seed;
        
        hash = 0x364BD2EE336025ABL * ((byte)c        ^ (hash << 1) ^ (hash >>> 1));
        hash = 0x364BD2EE336025ABL * ((byte)(c >> 8) ^ (hash << 1) ^ (hash >>> 1));
		
		return hash;
	}

	public static long mzHash64(char c) {
        long hash = 0x364BD2EE336025ABL * ((byte)c ^ 0x896A359839B86BC1L);
        hash = 0x364BD2EE336025ABL * ((byte)(c >> 8) ^ (hash << 1) ^ (hash >>> 1));
        
        return hash;
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
		return b ? 0x96C82C5370677FDAL : 0x95A8D10CABCCA92BL;
	}

}



