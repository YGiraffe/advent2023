#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <errno.h>

char* substring(char* string, int startIndex, int len) {
    char* output = malloc(sizeof(char) * 6);
    // printf("strlen %lu\n", strlen(string));
    char* temp = string + startIndex;
    if (len > strlen(string)) {
        len = strlen(string) - 1;
    }
    strncpy(output, temp, len);
    return output;
}

int main() {
    FILE* rfile = fopen("input.txt", "r");
    char line_buff[100];
    int total = 0;

    while (fgets(line_buff, 99, rfile) != NULL) {
        // printf("'%s'\n", substring(line_buff, strlen(line_buff - 6), 5));
        for (int i = 0; i < strlen(line_buff); i++) {
            if (line_buff[i] >= 48 && line_buff[i] <= 57) {
                total += (((int) line_buff[i]) - 48) * 10;
                break;
            }
            else if (strcmp("zero", substring(line_buff, i, 4)) == 0) {
                break;
            }
            else if (strcmp("one", substring(line_buff, i, 3)) == 0) {
                total += 10;
                break;
            }
            else if (strcmp("two", substring(line_buff, i, 3)) == 0) {
                total += 20;
                break;
            }
            else if (strcmp("three", substring(line_buff, i, 5)) == 0) {
                total += 30;
                break;
            }
            else if (strcmp("four", substring(line_buff, i, 4)) == 0) {
                total += 40;
                break;
            }
            else if (strcmp("five", substring(line_buff, i, 4)) == 0) {
                total += 50;
                break;
            }
            else if (strcmp("six", substring(line_buff, i, 3)) == 0) {
                total += 60;
                break;
            }
            else if (strcmp("seven", substring(line_buff, i, 5)) == 0) {
                total += 70;
                break;
            }
            else if (strcmp("eight", substring(line_buff, i, 5)) == 0) {
                total += 80;
                break;
            }
            else if (strcmp("nine", substring(line_buff, i, 4)) == 0) {
                total += 90;
                break;
            }
        }
        printf("num1 %d\n", total);
        for (int i = strlen(line_buff) - 1; i >= 0; i--) {
            if (line_buff[i] >= 48 && line_buff[i] <= 57) {
                total += ((int) line_buff[i]) - 48;
                break;
            }
            else if (strlen(line_buff) >= 4 && strcmp("zero", substring(line_buff, i - 3, 4)) == 0) {
                break;
            }
            else if (strlen(line_buff) >= 3 && strcmp("one", substring(line_buff, i - 2, 3)) == 0) {
                total += 1;
                break;
            }
            else if (strlen(line_buff) >= 3 && strcmp("two", substring(line_buff, i - 2, 3)) == 0) {
                total += 2;
                break;
            }
            else if (strlen(line_buff) >= 5 && strcmp("three", substring(line_buff, i - 4, 5)) == 0) {
                total += 3;
                break;
            }
            else if (strlen(line_buff) >= 4 && strcmp("four", substring(line_buff, i - 3, 4)) == 0) {
                total += 4;
                break;
            }
            else if (strlen(line_buff) >= 4 && strcmp("five", substring(line_buff, i - 3, 4)) == 0) {
                total += 5;
                break;
            }
            else if (strlen(line_buff) >= 3 && strcmp("six", substring(line_buff, i - 2, 3)) == 0) {
                total += 6;
                break;
            }
            else if (strlen(line_buff) >= 5 && strcmp("seven", substring(line_buff, i - 4, 5)) == 0) {
                total += 7;
                break;
            }
            else if (strlen(line_buff) >= 5 && strcmp("eight", substring(line_buff, i - 4, 5)) == 0) {
                total += 8;
                break;
            }
            else if (strlen(line_buff) >= 4 && strcmp("nine", substring(line_buff, i - 3, 4)) == 0) {
                total += 9;
                break;
            }
        }
        printf("num2: %d\n", total);
    }
    printf("%d\n", total);
}
