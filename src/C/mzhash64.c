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

#include "mzhash64.h"

uint64_t mzhash64(const void* data, size_t length, uint64_t seed)
{
	const int8_t *bytes = (const int8_t*)data;
	uint64_t hash = 0xFA3BE25AB0E56E7FuLL ^ seed;

	while(length--)
		hash = 0x364BD2EE336025ABuLL * (*bytes++ ^ (hash << 1) ^ (hash >> 1));

	return hash;
}

uint64_t mzhash64_noseed(const void* data, size_t length)
{
	const int8_t *bytes = (const int8_t*)data;
	uint64_t hash = 0xFA3BE25AB0E56E7FuLL;

	while(length--)
		hash = 0x364BD2EE336025ABuLL * (*bytes++ ^ (hash << 1) ^ (hash >> 1));

	return hash;
}

uint64_t mzhash64_str(const char* str, uint64_t seed)
{
	uint64_t hash = 0xFA3BE25AB0E56E7FuLL ^ seed;

	while(*str)
		hash = 0x364BD2EE336025ABuLL * (*str++ ^ (hash << 1) ^ (hash >> 1));

	return hash;
}

uint64_t mzhash64_str_noseed(const char* str)
{
	uint64_t hash = 0xFA3BE25AB0E56E7FuLL;

	while(*str)
		hash = 0x364BD2EE336025ABuLL * (*str++ ^ (hash << 1) ^ (hash >> 1));

	return hash;
}

