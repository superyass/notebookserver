package ma.superyass.notebookserver.rest.controller;

import javax.servlet.http.HttpSession;
import ma.superyass.notebookserver.core.interpreters.ContextualInterpreter;
import ma.superyass.notebookserver.core.interpreters.InterpreterManager;
import ma.superyass.notebookserver.core.statements.Statement;
import ma.superyass.notebookserver.rest.dtos.ExecuteInputDTO;
import ma.superyass.notebookserver.rest.dtos.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author A-Y.boutahar
 */
@RestController
public class ExecuteController {
    
    @Autowired
    private InterpreterManager InterpreterManager;
    
    @ResponseBody
    @PostMapping("/execute")
    public ResultDTO execute(@RequestBody(required = true) ExecuteInputDTO dto, HttpSession session) {
        ContextualInterpreter ci = InterpreterManager.getInterpreter(dto.getCode());
        Statement s = ci.interprete(dto.getCode());
        //System.out.println(session.getId());
        return new ResultDTO(s.execute());
    }

}
