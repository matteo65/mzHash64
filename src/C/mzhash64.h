#ifndef _MZHASH64_H
#define _MZHASH64_H

#include <stddef.h> // size_t
#include <stdint.h> // uint64_t

#ifdef __cplusplus
extern "C" {
#endif

#define MZ_HASH_64_DEFAULT_SEED		0;

uint64_t mzhash64(const void* data, size_t length, uint64_t seed);
uint64_t mzhash64_noseed(const void* data, size_t length);
uint64_t mzhash64_str(const char* str, uint64_t seed);
uint64_t mzhash64_str_noseed(const char* str);

#ifdef __cplusplus
}
#endif

#endif