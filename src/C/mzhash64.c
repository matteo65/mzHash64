/**
 * mzhash64
 * 
 * Strong, fast, simple, non-cryptographic 32-bit hash function
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

#include "mzhash64.h"

uint64_t mzhash64(const void* data, size_t length, uint64_t seed)
{
	const int8_t *bytes = (const int8_t*)data;
	const int8_t *end = bytes + length;
	uint64_t hash = 0xA7BB53D6328B05DBuLL ^ seed;

	while(bytes != end)
		hash = 0xCAC39506BB87F535uLL * (*bytes++ ^ hash ^ (hash << 2) ^ (hash >> 2));

	return hash;
}

uint64_t mzhash64_noseed(const void* data, size_t length)
{
	const int8_t *bytes = (const int8_t*)data;
	const int8_t *end = bytes + length;
	uint64_t hash = 0xA7BB53D6328B05DBuLL;

	while(bytes != end)
		hash = 0xCAC39506BB87F535uLL * (*bytes++ ^ hash ^ (hash << 2) ^ (hash >> 2));

	return hash;
}

uint64_t mzhash64_str(const char* str, uint64_t seed)
{
	uint64_t hash = 0xA7BB53D6328B05DBuLL ^ seed;

	while(*str)
		hash = 0xCAC39506BB87F535uLL * (*str++ ^ hash ^ (hash << 2) ^ (hash >> 2));

	return hash;
}

uint64_t mzhash64_str_noseed(const char* str)
{
	uint64_t hash = 0xA7BB53D6328B05DBuLL;

	while(*str)
		hash = 0xCAC39506BB87F535uLL * (*str++ ^ hash ^ (hash << 2) ^ (hash >> 2));

	return hash;
}
