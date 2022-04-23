#include <cstdio>
#include <string>
#include <cstring>
#include <ctime>

int main() {
    time_t     now = time(0);
    struct tm  tstruct;
    char buf[80];
    tstruct = *localtime(&now);
    strftime(buf, sizeof(buf), "%Y-%m-%d_%H-%M-%S", &tstruct);
    std::string buf_s = buf;

    std::string nome_arquivo = "Contas"+buf_s+".txt";

    std::string comando1 = "ren doc_temp.temp "+nome_arquivo;

    std::string comando2 = "move "+nome_arquivo+" "+"C:\\Contas";

    printf("%s\n", nome_arquivo.c_str());
    printf("%s\n", comando1.c_str());
    printf("%s", comando2.c_str());


    system(comando1.c_str());
    system(comando2.c_str());
    return 0;
}
