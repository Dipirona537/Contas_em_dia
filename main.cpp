#include <cstdio>
#include <string>
#include <cstring>
#include <ctime>

int main() {
    time_t     now = time(nullptr);
    struct tm  tstruct{};
    char       buf[80];
    tstruct = *localtime(&now);
    strftime(buf, sizeof(buf), "%Y-%m-%d_%H-%M-%S", &tstruct);

    char* nome_arquivo = strdup("Contas");
    nome_arquivo = strcat(nome_arquivo, buf);

    char* comando1 = strdup("ren doc_temp.temp ");
    comando1 = strcat(comando1, nome_arquivo);
    strcat(comando1, ".txt");

    char* comando2 = strdup("move ");
    comando2 = strcat(comando2, nome_arquivo);
    comando2 = strcat(comando2, ".txt");
    comando2 = strcat(comando2, " C:\\Contas");

    printf("%s\n", comando1);
    printf("%s\n", comando2);

    system(comando1);
    system(comando2);
    return 0;
}
