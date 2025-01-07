package standard;

import org.assertj.core.api.StandardSoftAssertionsProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {

    // 테스트 전처리
    @BeforeAll
    static void beforeALL() {
        System.out.println("테스트 실행 전에 한번 실행");
        Util.File.createDir("test");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("테스트 실행 후에 한번 실행");
        Util.File.delete("test");
    }



    // 테스트 후처리
    @Test
    @DisplayName("최초의 파일 테스트")
    void t1() {
        Util.File.test();
    }

    @Test
    @DisplayName("파일 생성. 내용이 없는 빈 파일 생성")
    void t2() {

        String file = "test/test.txt";

        Util.File.createFile(file); // 파일 생성 ok

        assertThat(Files.exists(Paths.get(file)))
                .isTrue();
    }

    @Test
    @DisplayName("파일 내용 읽어오기")
    void t3() {
        String file = "test/test.txt";
        String testContent = "Hello, World";

        Util.File.write(file, testContent);
        String content = Util.File.readAsString(file);

        assertThat(content)
                .isEqualTo(testContent);
    }

    @Test
    @DisplayName("파일 내용 수정")
    void t4() {

        String file = "test/test.txt";
        String writeContent = "modify content";

        Util.File.write(file, writeContent);
        String readContent = Util.File.readAsString(file);

        assertThat(readContent)
                .isEqualTo(writeContent);
    }

    @Test
    @DisplayName("파일 삭제")
    void t5() {

        String file = "test/test.txt";

        // test3.txt 파일 생성
        Util.File.createFile(file);
        assertThat(Files.exists(Paths.get(file)))
                .isTrue();

        // test3.txt 파일 삭제
        Util.File.delete(file);

        // test3.txt 존재 여부 확인
        assertThat(Files.exists(Paths.get(file)))
                .isFalse();

    }

    @Test
    @DisplayName("폴더 생성")
    void t6() {

        String dirPath = "test";

        Util.File.createDir(dirPath);

        assertThat(Files.exists(Paths.get(dirPath)))
                .isTrue();

        assertThat(Files.isDirectory(Path.of(dirPath)))
                .isTrue();

    }

    @Test
    @DisplayName("폴더 삭제")
    void t7() {

        String dirPath = "test";

        Util.File.delete(dirPath);

        assertThat(Files.exists(Paths.get(dirPath)))
                .isFalse();
    }
    @Test
    @DisplayName("파일 생성시 없는 폴더에 생성시도시 폴더를 생성한 후에 파일 생성")
    void t8() {
        // 폴더가 없으면 폴더를 생성하고 파일생성
        String path = "test/test2/test.txt";

        Util.File.createFile(path);

        boolean rst = Files.exists(Paths.get(path));
        assertThat(rst)
                .isTrue();
    }
}