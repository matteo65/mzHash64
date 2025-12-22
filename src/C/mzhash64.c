/**
 * mzhash64
 * 
 * Strong, fast, simple, non-cryptographic 32-bit hash function
 * 
 * Author: Matteo Zapparoli
 * Date: 2025-12
 * Reelease: 4
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
	uint64_t hash = 0xDED46DB8C47B7480uLL ^ seed;

	while(length--)
		hash = 0xE958AC98E3D243C3uLL * (*bytes++ ^ (hash << 2) ^ (hash >> 2));

	return hash;
}

uint64_t mzhash64_noseed(const void* data, size_t length)
{
	const int8_t *bytes = (const int8_t*)data;
	uint64_t hash = 0xDED46DB8C47B7480uLL;

	while(length--)
		hash = 0xE958AC98E3D243C3uLL * (*bytes++ ^ (hash << 2) ^ (hash >> 2));

	return hash;
}

uint64_t mzhash64_str(const char* str, uint64_t seed)
{
	uint64_t hash = 0xDED46DB8C47B7480uLL ^ seed;

	while(*str)
		hash = 0xE958AC98E3D243C3uLL * (*str++ ^ (hash << 2) ^ (hash >> 2));

	return hash;
}

uint64_t mzhash64_str_noseed(const char* str)
{
	uint64_t hash = 0xDED46DB8C47B7480uLL;

	while(*str)
		hash = 0xE958AC98E3D243C3uLL * (*str++ ^ (hash << 2) ^ (hash >> 2));

	return hash;
}


