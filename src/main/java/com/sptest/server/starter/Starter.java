package com.sptest.server.starter;

import com.sptest.server.config.AppConfig;
import com.sptest.server.dao.model.dto.AccountDTO;
import com.sptest.server.dao.model.dto.GameDTO;
import com.sptest.server.dao.model.dto.PlayerDTO;
import com.sptest.server.services.IPlayerService;
import java.io.FileNotFoundException;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Starter {

    public static Logger logger = LoggerFactory.getLogger(Starter.class.getName());


    public static void main(String[] args) throws FileNotFoundException, BeansException {
        logger.info("hello from sl4j");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            AppConfig.class);

       /* IRoleService roleService = context.getBean(IRoleService.class);
        RoleEntity role1 = new RoleEntity("student", 1200, 410113);
        RoleEntity role2 = new RoleEntity("prepod", 8100, 4100115);

        EmployeeEntity employeeEntity1 = new EmployeeEntity("Lola", 22, "Lola address");
        EmployeeEntity employeeEntity2 = new EmployeeEntity("Masha", 23, "masha adress");
        EmployeeEntity employeeEntity3 = new EmployeeEntity("Vika", 20, "vika address");

        role1.getEmployees().add(employeeEntity1);
        role1.getEmployees().add(employeeEntity2);
        role1.getEmployees().add(employeeEntity3);

        role2.getEmployees().add(employeeEntity1);
        role2.getEmployees().add(employeeEntity2);
        role2.getEmployees().add(employeeEntity3);

        roleService.save(role1);
        roleService.save(role2);*/
       /* IMoneyReportService reportService = context.getBean(IMoneyReportService.class);

        MoneyReport moneyReport1 = new MoneyReport(1232,"19", "100", "124.45f", "23123123");
        MoneyReport moneyReport2 = new MoneyReport(1221,"189", "200", "145325.45f",
            String.valueOf(System.currentTimeMillis()));
        MoneyReport moneyReport3 = new MoneyReport(1255,"989", "300", "19999.45f",
            String.valueOf(System.currentTimeMillis()));
        MoneyReport moneyReport4 = new MoneyReport(1299, "568","400", "145234.45f",
            String.valueOf(System.currentTimeMillis()));
        reportService.create(moneyReport1);
        reportService.create(moneyReport2);
        reportService.create(moneyReport3);
        reportService.create(moneyReport4);
        reportService.findAll().forEach(System.out::println);*/

        IPlayerService playerService = context.getBean(IPlayerService.class);
        /*PlayerDTO playerDTO = new PlayerDTO(35, "Bespalova 56", 181, "Yarik", "testemail@yadenx.ru");
        Set<GameDTO> games = new HashSet<>();
        games.add(new GameDTO("GTA", 50.5f, "Biosystem", playerDTO));
        games.add(new GameDTO("Lineage2", 100.5f, "Microsystem", playerDTO));
        games.add(new GameDTO("FIFA2010", 123.5f, "Namco", playerDTO));
        games.add(new GameDTO("WoW", 504.5f, "Blizzard", playerDTO));
        games.add(new GameDTO("WoT", 505.5f, "Wargaming", playerDTO));
        AccountDTO lineageAccount = new AccountDTO("vendetta529", "52232",
            System.currentTimeMillis());
        lineageAccount.setPlayerDTO(playerDTO);
        AccountDTO dotaAccount = new AccountDTO("blizzcon@yandex.ru", "52532",
            System.currentTimeMillis());
        dotaAccount.setPlayerDTO(playerDTO);
        Set<AccountDTO> accountDTOSet = new HashSet<>();
        accountDTOSet.add(lineageAccount);
        accountDTOSet.add(dotaAccount);
        playerDTO.setAccounts(accountDTOSet);
        playerDTO.setGames(games);
        playerService.save(playerDTO);*/

        PlayerDTO test = playerService.findPlayerByID(105);
        System.out.println(test);
        Set<AccountDTO> accounts = test.getAccounts();
        Set<GameDTO> games = test.getGames();
        System.out.println("Accounts");
        if (accounts != null && !accounts.isEmpty()) {
            accounts.forEach(System.out::println);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Games");
        if (games != null && !games.isEmpty()) {
            games.forEach(System.out::println);

        }


    }

}
