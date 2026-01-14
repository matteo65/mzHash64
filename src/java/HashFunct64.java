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
        long hash = 0xB04C2438F4F7D8D1L ^ seed;
        
        for(int i = 0; i < length; i++)
            hash = 0xD76F648260B0F9FDL * (data[start + i] ^ (hash << 8) ^ (hash >>> 8));
        
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
		long hash = 0xB04C2438F4F7D8D1L ^ seed;
		return 0xD76F648260B0F9FDL * (b ^ (hash << 8) ^ (hash >>> 8));
	}

	public static long mzHash64(byte b) {
		return 0xD76F648260B0F9FDL * (b ^ 0x4C9474D0CF2C26D8L);
	}

	public static long mzHash64(short s, long seed) {
	    long hash = 0xB04C2438F4F7D8D1L ^ seed;
		
		hash = 0xD76F648260B0F9FDL * ((byte)s        ^ (hash << 8) ^ (hash >>> 8));
		hash = 0xD76F648260B0F9FDL * ((byte)(s >> 8) ^ (hash << 8) ^ (hash >>> 8));
		
		return hash;
	}

	public static long mzHash64(short s) {   
        long hash = 0xD76F648260B0F9FDL * ((byte)s ^ 0x4C9474D0CF2C26D8L);
        hash = 0xD76F648260B0F9FDL * ((byte)(s >> 8) ^ (hash << 8) ^ (hash >>> 8));
        
        return hash;
	}

	public static long mzHash64(int i, long seed) {
		long hash = 0xB04C2438F4F7D8D1L ^ seed;
		
		hash = 0xD76F648260B0F9FDL * ((byte)i         ^ (hash << 8) ^ (hash >>> 8));
		hash = 0xD76F648260B0F9FDL * ((byte)(i >> 8)  ^ (hash << 8) ^ (hash >>> 8));
		hash = 0xD76F648260B0F9FDL * ((byte)(i >> 16) ^ (hash << 8) ^ (hash >>> 8));
		hash = 0xD76F648260B0F9FDL * ((byte)(i >> 24) ^ (hash << 8) ^ (hash >>> 8));
		
		return hash;
	}

	public static long mzHash64(int i) {
        long hash = 0xD76F648260B0F9FDL * ((byte)i ^ 0x4C9474D0CF2C26D8L);
        hash = 0xD76F648260B0F9FDL * ((byte)(i >> 8)  ^ (hash << 8) ^ (hash >>> 8));
        hash = 0xD76F648260B0F9FDL * ((byte)(i >> 16) ^ (hash << 8) ^ (hash >>> 8));
        hash = 0xD76F648260B0F9FDL * ((byte)(i >> 24) ^ (hash << 8) ^ (hash >>> 8));
        
        return hash;
	}

	public static long mzHash64(long l, long seed) {
		long hash = 0xB04C2438F4F7D8D1L ^ seed;
		
		hash = 0xD76F648260B0F9FDL * ((byte)l         ^ (hash << 8) ^ (hash >>> 8));
		hash = 0xD76F648260B0F9FDL * ((byte)(l >> 8)  ^ (hash << 8) ^ (hash >>> 8));
		hash = 0xD76F648260B0F9FDL * ((byte)(l >> 16) ^ (hash << 8) ^ (hash >>> 8));
		hash = 0xD76F648260B0F9FDL * ((byte)(l >> 24) ^ (hash << 8) ^ (hash >>> 8));
		hash = 0xD76F648260B0F9FDL * ((byte)(l >> 32) ^ (hash << 8) ^ (hash >>> 8));
		hash = 0xD76F648260B0F9FDL * ((byte)(l >> 40) ^ (hash << 8) ^ (hash >>> 8));
		hash = 0xD76F648260B0F9FDL * ((byte)(l >> 48) ^ (hash << 8) ^ (hash >>> 8));
		hash = 0xD76F648260B0F9FDL * ((byte)(l >> 56) ^ (hash << 8) ^ (hash >>> 8));
		
		return hash;
	}

	public static long mzHash64(long l) {
        long hash = 0xD76F648260B0F9FDL * ((byte)l ^ 0x4C9474D0CF2C26D8L);
        hash = 0xD76F648260B0F9FDL * ((byte)(l >> 8)  ^ (hash << 8) ^ (hash >>> 8));
        hash = 0xD76F648260B0F9FDL * ((byte)(l >> 16) ^ (hash << 8) ^ (hash >>> 8));
        hash = 0xD76F648260B0F9FDL * ((byte)(l >> 24) ^ (hash << 8) ^ (hash >>> 8));
        hash = 0xD76F648260B0F9FDL * ((byte)(l >> 32) ^ (hash << 8) ^ (hash >>> 8));
        hash = 0xD76F648260B0F9FDL * ((byte)(l >> 40) ^ (hash << 8) ^ (hash >>> 8));
        hash = 0xD76F648260B0F9FDL * ((byte)(l >> 48) ^ (hash << 8) ^ (hash >>> 8));
        hash = 0xD76F648260B0F9FDL * ((byte)(l >> 56) ^ (hash << 8) ^ (hash >>> 8));
        
        return hash;
	}

	public static long mzHash64(char c, long seed) {
        long hash = 0xB04C2438F4F7D8D1L ^ seed;
        
        hash = 0xD76F648260B0F9FDL * ((byte)c        ^ (hash << 8) ^ (hash >>> 8));
        hash = 0xD76F648260B0F9FDL * ((byte)(c >> 8) ^ (hash << 8) ^ (hash >>> 8));
		
		return hash;
	}

	public static long mzHash64(char c) {
        long hash = 0xD76F648260B0F9FDL * ((byte)c ^ 0x4C9474D0CF2C26D8L);
        hash = 0xD76F648260B0F9FDL * ((byte)(c >> 8) ^ (hash << 8) ^ (hash >>> 8));
        
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
		return b ? 0xFF7A97FCE23701BCL : 0x626A3B0947ACC474L;
	}

}
