import com.test.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by fcamara744 on 29/01/18.
 */
@RestController
@Component
public class SchedullerController {

    private static final Logger log = LoggerFactory.getLogger(SchedullerController.class);

    @Autowired
    private TestService mailServiceTest;

    @Scheduled(cron="0 0 0 1/1 * ?") // todo dia a meia-noite
    @RequestMapping(path="/enviar", method = RequestMethod.GET)
    public void findMails() {
        log.info("Iniciando scheduler de geracao de relatorio de lancamentos");
        this.sendEmail();
        log.info("Scheduler de geracao de relatorio de lancamentos encerrado");
    }

    @Scheduled(cron="0 0 0 1/1 * ?") // todo dia a meia-noite
    @RequestMapping(path="/gerar", method = RequestMethod.POST)
    public void acess() {
        log.info("Iniciando scheduler de geracao de relatorio de lancamentos");
        this.sendEmail();
        log.info("Scheduler de geracao de relatorio de lancamentos encerrado");
    }

    public void sendEmail(){
    try {
        mailServiceTest.sendPlainTextEmail();
    }catch(UnsupportedEncodingException e){
        e.printStackTrace();
    }catch(IOException e){
        e.printStackTrace();
    }catch(Exception e){
        e.getMessage();
    }
    }
}
