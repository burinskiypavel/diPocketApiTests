package appmanager;

import io.restassured.response.Response;
import model.telenor.cardOperation.unblockCard.clientDiPAccounts2.Account;
import model.telenor.cardOperation.unblockCard.clientDiPAccounts2.ClientDiPAccounts2UnblockCard;
import model.telenor.login.accountHistoryList.AccountHistoryList;
import model.telenor.login.accountHistoryList.AccountHistoryList_;
import model.telenor.login.auth_authenticate.Address;
import model.telenor.login.auth_authenticate.AuthAuthenticate;
import model.telenor.login.auth_authenticate.Imagesstatus;
import model.telenor.login.clientDiPAccounts2.Accountt;
import model.telenor.login.clientDiPAccounts2.ClientDiPAccounts;
import model.telenor.login.clientImages.Image;
import model.telenor.login.clientInfo.ClientInfo;
import model.telenor.registration.mailsac.Mailsacc;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorHelper extends HelperBase {

    public void checkAllFieldsOfTelenorClientImagesResponse(Image[] images) {
        assertThat(images[0].getTypeId(), equalTo("1"));
        //assertThat(images[0].getBase64Image(), equalTo("/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\r\nHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\r\nMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAB4AKADASIA\r\nAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\r\nAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\r\nODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\r\np6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\r\nAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\r\nBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\r\nU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\r\nuLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDL2j0o\r\nKClLjNIXGaCRNo9KPLz2pdwp6sM9aBiCHnipkiBpVIz1qZMUhgsI9KmEPtTkxUykUARCPHaniOpB\r\nt60uRQA0IKdsHSgMPWnBxQAhjFRmMVNvFNLCmBAyD0qB0FWXYVAzCgRAyj0qJkqdmFRMwzQJlaRQ\r\nAeKzZhzWjM4wazZnGetMB5n96PO96ohzS7sikMvCb3p6y+9UVY5qVTQMvpPxVlJ/esxSamRiKQGq\r\ns2ak87FZyScVIHJoAvfaPel8/wB6ohqC1AFv7R70oufeqOTSg5oAvfafekNz71RycUm40AW2uM96\r\nha4warnNQsTTAsNPUDz80wkmoWzQIJp+OtZs1xnvU1weKyrhyKBmqIz1p6xe1aK2vtUgtfagRnrG\r\nfSpUhOa0EtMnpVhbQelAzOWI+lPEZrTW0HpUgtQe1IDLVD6VKENaK2mD0qQWg9KBmYIzS+UTWp9m\r\nHpTha+1AGV5Z9KXyyeorU+yj0o+yj0oAyjD7U3yTWyLUUn2T2oEYphPpTGgPpW2bUc8Uw2w9KYGE\r\nYjUTRHHStxrUelQvajnigDm7pODWRPGTziuqu7bGeKyZbbnpQB0ioKlCUiCp1WgSESPParCR+1Ig\r\nqdaBiCMelPEYpwFPUUgGhB6U8IKcB608CgCLZTggp9AFAxNg9KUR04U8LzQBHs9qQx+1WNtIVoEV\r\nWTnpUbJx0q4yj0qvIKAKzJxUDpVthUMgpgZF2M9qyJV5rZuz1rIlHNAG0hqwlV0HNWExQSTJzU6g\r\nVClTLQMlApw601aeB3oGOAooozSAXvThTBUgFAxypUgWkXjFSLQAu2mEYqXtTSKBER6Yqs4NWTUM\r\nlMCuwqCXgVYbiqsx4oAyrs9aypetaN2ck1mvyaANtOtTpUCVPHTJROnBqdahSp05pDJVFSDiowKe\r\nKBi0UhNJnNADhUi1EKepoAmFSCogaeW4oAfupjPxUZeo2egB7NULtSM/FRM1ACOaqTnANTO1Vbhv\r\nloEZNy3J5qg55q1cN8xqkx5oA3UParCGqak96sI1UTcuxkVOpFU0ap1akMtBuacGqvupwfNAyYtm\r\nk7VHvFLu4pDJAQKeDzUAbmnq2KAJwcc0hc1FuxSF+KAHs+Kid6QvUbNzQApamFuKYSaaTTEKze9U\r\n7l/lOKnY1SuWwDRYDMnOSaqk1NKeahzk0Aaiv05qwj980UVo0STo49amV6KKgEP305X96KKRQ7f7\r\n04NRRQA7dTg9FFIYm/3ppfPeiigBvmUhbNFFMBpYUxmoopiI2NUbphiiijqIypD1qNfvCiihAf/Z"));
        assertThat(images[0].getBase64Image(), equalTo("/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\r\nHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\r\nMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAB8AH0DASIA\r\nAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\r\nAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\r\nODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\r\np6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\r\nAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\r\nBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\r\nU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\r\nuLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDmaKKK\r\n8M/XAooooAKKKKACiiigApQxUgqSCOhBwaSigB7TSuMNLIw9GckUyiimCVgooopAFKKSgUAFFFFA\r\nBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABSikoFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQ\r\nAUCigUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABQKKBQAUUUUAFFFFABRRRQAUUUUAFFFF\r\nABRRRQAUUUUAFAooFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUCigUAFFFFABRRRQAUUU\r\nUAFFFFABRRRQAUUUUAFFFFABQKKBQAUU512uR6UmKAEopcUYoASilxRigBKKXFGKAEopcUYoASil\r\nxRigBKKXFGKAEoFLiigD/9k="));
        assertThat(images[0].getStateID(), equalTo("10"));//0
        assertThat(images[0].getImageType(), equalTo("SELFIE"));
        assertThat(images[0].getImageState(), equalTo("APPROVED"));

        assertThat(images[1].getTypeId(), equalTo("2"));
        assertThat(images[1].getBase64Image(), equalTo("/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\r\nHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\r\nMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAB4AKADASIA\r\nAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\r\nAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\r\nODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\r\np6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\r\nAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\r\nBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\r\nU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\r\nuLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDM2CkK\r\nCnFx69abvX1oJE2e1LsyaAw9aepGaBgIgalSGlUjirCYNIBqRVMsPtT0xUwIoGQiPtipAgzUgxRk\r\nUAIsY9KXyxmlDCnBhQA3yxTGTnpU24U0sKAIGSoHUZqy7Cq7MKYiBlFRsuM1OzCoWYUCK8igLWbP\r\n1NaMrjBrMmcZPNMB/nUedVLefWlDHPWkMvCapFl96oAmpVJ4pDLyz+9WY5+nNZqk1MjEUAaqTe9S\r\nCbHes5H4qQPmgC95/vQZ+OtUg5pCxoAufaMd6UXHvVHJpRkUAXjc003PvVIsaaWJoAttcj1qFrj5\r\nutV2JqJiaYFhrioWn96iOTULZzQIJp+OtZs83Xmp7gnBrJuHIzQBrCM08Rn0rRW29qkFrQBnLHUy\r\nRVoJacjip0tAO1IZnLEcdKeIjWotr7U8WvtQBlrG1Sqp9K0hac9KkFoPSgZmCM0vlH0rU+yj0pRa\r\n+1IDLERNL5RrUFr7UfZcUwMoxH0phiNbItKT7IPSgRimE+lMaEntW4bUelRm1HpTAw2iPpUTx+1b\r\nrWo9Kge1XHSgDm7lODWRPESeldVd23HSsmW2GelAHRqmalVPakUdBU6LQIEQelWFjpFX2qZRQMBG\r\nPSnhBmlAqQCkAwIM9KkCU4CnADFAEeylC8080oFAxNgpdgpwp6ikBGEpDGPSp9tBWmIqtGKjZOKt\r\nlagcc0wKzJx0qB09RVtqhkHFAGReKOayJV56VsXnesmYc0AbKVYSoE4qdKCSdamSok5qZenSgokF\r\nPApq0+gBwxRRRSAKeOaYKkUHrQMcFqQLSLUgFABikIwakxxTTQIhaq7irLdagkHOaYFdhzUMuMVY\r\nfiqsx4oAyrvvWVKea0rtutZbnJoA21qdKgTrViOmSidKnWoUqdRmkMkWpO1MWnjpQMWkzQeKTNAD\r\nhUimogeaepxQBMDUgNQqQafuGKQEhIHemM9Rl6jZqYDmaoZGzSM9RM9ACOfU1VmPympmaqlw3BoE\r\nZV03JrPY81buD8xqk3NMDcU1ZQ96pq1WEbvTZKLsZzU69apo9Tq1IZZVqfuGKrb6cHoGTE5NHeot\r\n/NLupDJQaeDVcNUitQBMD3oL1FuHrSF+KAHs1RM9NLZqNjQA5npjNxTCeaYTTAVmqpcv8pqdjVG5\r\nPymgRmznmqrGppTyagzzxQDNRGqwr+lFFW1qSWEeplf3oopDHh6cH4ooqbDHbqcGoooQDg1OD0UU\r\nDEL00ye9FFADfMppfNFFAhMimMaKKAImbmqN03FFFMDLkbrUS/eoooW4mf/Z"));
        assertThat(images[1].getStateID(), equalTo("10"));//0
        assertThat(images[1].getImageType(), equalTo("PHOTOID"));
        assertThat(images[1].getImageState(), equalTo("APPROVED"));

        assertThat(images[2].getTypeId(), equalTo("3"));
        assertThat(images[2].getBase64Image(), equalTo("/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\r\nHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\r\nMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAB4AKADASIA\r\nAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\r\nAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\r\nODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\r\np6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\r\nAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\r\nBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\r\nU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\r\nuLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDM2Ck2\r\nDsKcZBmkLgnigkQJ7UCPJpQwp6EUDBYhUqxChSKsJigY1YhnpU6w05cCpgVoAiEWO1PEfNSfLml4\r\nFIBoQZpwQZo3CnKw9aAEMYx0qNoxUxcU0stMCBk9agZRVl296gdqBEDIPSomQY6VOzLUTuM9aAKs\r\nq4Ws6YZJzWlK4xWZO4yaYkO86jzqpbzS7jj3pDLwmNSLLVBSc1KpNAF9JsGrCT1mqTUyMRSGaqTZ\r\nFSCb3rOSSpA/FAF7z6Uz1RDnFG4mgC59o96Bcc9ao5pc0AXvtPvSG596o7jTSTTAuNc1C9x71WYm\r\no2JxQBO0+T1qFp6iJNQvmgBZp8L1rMmuOvNTzk4rKuH5oFY1RGTziniM9a0FtvapVtRjpQBnrFUq\r\nxHNaK2ntU62gwOKBmcsR9KeIj6Vpraj0qQWo9KAMtY2zUoQ+laItfapBaCkMzBGcUvlGtQWopRbC\r\ngDL8o+lL5Rx0rU+y80fZfagDKMXtTTEa2Ba0fZR6UCMUxH0NMMJNbbWwqM2o9KYGG0R9KjeLjpW4\r\n1qPSoHtR6UAc3cxkA1kTxk9q6q7tgM8cVky23PSgDo0TmpVShBU6CglAiVOkdIi1Oo4oKECU8IKc\r\nBTwKQDQgz0p4SnAU8YoAi2YpwQU+gUDECcdKUIPSninAUAR+XzR5dThaQigCqyVGycVcK8VA/WmI\r\nqsnFQMnWrZ6VDIOKAMi8HWsiVRmtm771kS8mgRspVhKgUc1OlAiwtSpUSip1FAyQU4U1etSCgYoF\r\nLRSUAL3pwFNFPUUhjlWpFWkWpRQAbaaRUnamkUxETc1Xcdast1xUD9aAK5FQS8CrDnmq0x4oAybs\r\n5zWVLwa0btutZr8mmI21qdKrpVhKCUTpU61CnSp1oKJVx6U/tTBTxSAWig0lAxRUimogakU80ASj\r\nrUoqFTzT94xQA8t701n4qIvUbPQA9myahduaQvUbPQA1zVWY4U1MzZqpcNwaYjJuX5NUGPzVauG+\r\nY1SJ5oA3UPNWENU1arCNVNEl2M5FWFOBVJHqdHpWGWgacGqsHp4ekMmLUVFvpd3vQMlBpwNQAnNP\r\nDc0gJw1G7NRb8U0vx1oAkZ8d6iZ6aW96jY8UAKz00vxTGNMJpiFZsVSuZPlNWGPFUbk/KaYGbO2S\r\naqseamlPJqDOTSQGqr89anR6KK0sQWFephJRRU2KH76cHzRRSYIdu96eGoopDFD04PRRQMQye9NM\r\nlFFADS9NL0UUCEzTCaKKaEyNjVG6bjmiinYDKlPU1EvLCiiktxn/2Q=="));
        assertThat(images[2].getStateID(), equalTo("10"));
        assertThat(images[2].getImageType(), equalTo("PROOFOFADDRESS"));
        assertThat(images[2].getImageState(), equalTo("APPROVED"));

        assertThat(images[3].getTypeId(), equalTo("4"));
        //assertThat(images[3].getBase64Image(), equalTo("/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\r\nHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\r\nMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAB4AKADASIA\r\nAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\r\nAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\r\nODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\r\np6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\r\nAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\r\nBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\r\nU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\r\nuLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDL2YpC\r\ngpxcetNLj8aBBsFHlilDD1pysM9aAFWOpUiHpQrDtVhMcUhjVhGelTLCPSnpiphjFAEQiGKeE9qk\r\nGKMigBAg9KXYKUMM04MKAGmMYphj9qm3DFNLD1pgQMg9KgZB6VZdhUDMKAICoqNkGamZhULuKBFa\r\nUcGs6cDmtGZxisyZxk0ASed70nnVSDketKHNAF4Tc9akE1UFJqZTmkMupMfWrMc/vWcualUkUAay\r\nTZ70/wA/FZyOakDk0AXvP96PPx3qluzQWOKALZuPelFx71Ry2aMmgC/9o96Q3PvVEsaaWNAFx7nj\r\nrUBuOKrsTUbHBpgTvce9QtP71EaifIoAJ5+OKzJp8EnNT3BOOtZVw+CaANURnPtThEc1pLa+1SLa\r\nD0oAz1j9qlWI+laCWntVhbQelAGcsRx0p4iNaS2ox0qQWgx0pAZio3pUioeeK0ha47VILUelAzME\r\nZpfKJrU+y+1KLUelILmWIj6UvlnHStT7L7UfZaYGWYvamGE9hWwLX2o+y+1AGKYT6VGYT6VuNaj0\r\nqM2ox0oEYZiI7VE8ZNbjWox0qF7UelMDm7pCFPFZE0ZJ6Zrqru2AzxWTLbDPSgDo1jqZU9qRBU6r\r\nmgQJGKmWMYoRfWplGKBgEHpTggp4FOApANCc1IEpQKeBQMZsoC0/FKBSGJspfLpw9KeozQBH5ftS\r\nGOrG2kK0xMqslRlKuMvtVdxjNMRVaOoWSrZqCQcUAZN4vWsiVRmti74rJlzzQBtIasJVdKsJQInS\r\nplFQoKmWgZIKeBTRzT8UAOAooFGfakAtKKaKkUUDHKtSqvNNHFSCgBcU0ipMU0igCFuRVdxVlqgk\r\n60xEBHNQS9KsMRVaY8UAZN2eTWVKa0rtuTzWW/LUAbi1OlV06VYSmIsJUy4qFKnWkBIKkFMXmn96\r\nBi0hoJpKAHLUi1CDUimkMmWpBUSmnFhigCTdTGf3qMvUbPTEPL1C7ZFNLVGz0ANc1Vnbg1M7VUuG\r\n+WgDKum5NZ7HnNW7hjk1TbrQBuKeasIcVTU+9WEaqZJdQ1OpqojVMrcUhlkNinhqrb6eHpDJScmi\r\no91G4UASg4p4NVwakVvWgCYGgtxUW+kZ+KAHlqiZ6QtmomNADmemM3FMJ5ppNMBS1Url/lNWGNUb\r\no/LQIzZ2yTVUnmppW+Y1D/FQBqI/PNWEfpRRVkosK9SrJRRUjHh6cHoopMY7fTg1FFIY4PS76KKd\r\ngDzKaXoooAbvppaiikAhYetMY0UUxEbHmqF0wx1oopgZch5NRLy1FFAH/9k="));
        assertThat(images[0].getBase64Image(), equalTo("/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\r\nHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\r\nMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAB8AH0DASIA\r\nAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\r\nAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\r\nODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\r\np6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\r\nAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\r\nBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\r\nU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\r\nuLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDmaKKK\r\n8M/XAooooAKKKKACiiigApQxUgqSCOhBwaSigB7TSuMNLIw9GckUyiimCVgooopAFKKSgUAFFFFA\r\nBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABSikoFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQ\r\nAUCigUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABQKKBQAUUUUAFFFFABRRRQAUUUUAFFFF\r\nABRRRQAUUUUAFAooFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUCigUAFFFFABRRRQAUUU\r\nUAFFFFABRRRQAUUUUAFFFFABQKKBQAUU512uR6UmKAEopcUYoASilxRigBKKXFGKAEopcUYoASil\r\nxRigBKKXFGKAEoFLiigD/9k="));
        assertThat(images[3].getStateID(), equalTo("10"));
        assertThat(images[3].getImageType(), equalTo("SELFIE2"));
        assertThat(images[3].getImageState(), equalTo("APPROVED"));
    }

    public void checkAllRowsOfTelenorClientInfoResponse(ClientInfo clientInfo) {
        assertThat(clientInfo.getId(), equalTo(30943));
        assertThat(clientInfo.getClientFirstName(), equalTo("Pavel"));
        assertThat(clientInfo.getClientLastName(), equalTo("Test"));
        assertThat(clientInfo.getPresentedLogin(), equalTo("380685448615"));
        assertThat(clientInfo.getCountryId(), equalTo(826));
        assertThat(clientInfo.getResidenceCountryId(), equalTo(616));
        assertThat(clientInfo.getLangId(), equalTo(1));
        assertThat(clientInfo.getMainPhone(), equalTo("380685448615"));
        assertThat(clientInfo.getEmail(), equalTo("assetspb@gmail.com"));
        assertThat(clientInfo.isEmailIsVerified(), equalTo(true));
        assertThat(clientInfo.getCurrencyId(), equalTo(348));
        assertThat(clientInfo.getSecQuestion(), equalTo("QA"));
        assertThat(clientInfo.getSecAnswerAttemptCnt(), equalTo(0));
        assertThat(clientInfo.getStateId(), equalTo(1));
        assertThat(clientInfo.isAddDocsAvail(), equalTo(false));
        assertThat(clientInfo.getCcyCode(), equalTo("HUF"));
        assertThat(clientInfo.getBirthDate(), equalTo("946677600000"));
        assertThat(clientInfo.getBirthDateAsDate(), equalTo("2000-01-01"));
        assertThat(clientInfo.getDdStatus(), equalTo("FDD"));
        assertThat(clientInfo.getCardholderName(), equalTo("Pavel Test"));
        assertThat(clientInfo.isRegisteredAddrAsmail(), equalTo(true));
        assertThat(clientInfo.getCardholderNameState(), equalTo("VERIFIED"));
        assertThat(clientInfo.getSite(), equalTo("TELENOR"));
        assertThat(clientInfo.getSiteEnum(), equalTo("TELENOR"));
        assertThat(clientInfo.isStrongPassword(), equalTo(false));
        assertThat(clientInfo.getClientType(), equalTo("INDIVIDUAL"));
        assertThat(clientInfo.getFullName(), equalTo("Pavel Test"));
        assertThat(clientInfo.isClientBlocked(), equalTo(false));
        assertThat(clientInfo.isClientBanned(), equalTo(false));
    }

    public void checkAllRowsInTelenorFullRegClientInfoResponse(ClientInfo clientInfo) {
        assertThat(clientInfo.getClientFirstName(), equalTo("Pavel"));
        assertThat(clientInfo.getClientLastName(), equalTo("TestQA"));
        assertThat(clientInfo.getPresentedLogin(), equalTo("380980316499"));
        assertThat(clientInfo.getMainPhone(), equalTo("380980316499"));
        assertThat(clientInfo.getEmail(), equalTo("telenorchangeemailtest@mailsac.com"));//pavelqaemail@mailsac.com
        assertThat(clientInfo.getCcyCode(), equalTo("HUF"));
    }

    public void checkAllFieldsFromTelenorClientDiPAccounts2Response(ClientDiPAccounts clientDiPAccounts) {
        SoftAssert softAssert = new SoftAssert();
        List<Accountt> accounts = clientDiPAccounts.getAccounts();
        for(Accountt accountt : accounts) {
            assertThat(accountt.getAccountId(), equalTo(9434));
            assertThat(accountt.getAccountName(), equalTo("Band 512047269"));
            softAssert.assertEquals(accountt.getCcy(), "HUF");
            assertThat(accountt.getCcyId(), equalTo(348));
            assertThat(accountt.getBalance(), notNullValue());//check greater that 0
            assertThat(accountt.getAvailableBalance(), notNullValue());
            assertThat(accountt.getBlocked(), equalTo(0));
            //assertThat(accountt.getPlasticCardId(), equalTo(14932));
            //assertThat(accountt.getPlasticMaskedPan(), equalTo("545598******6620"));
            softAssert.assertTrue(accountt.getMain().equals(true), "Main is not true");
            assertThat(accountt.getIsDefault(), equalTo(true));
            assertThat(accountt.getOwn(), equalTo(true));
            assertThat(accountt.getShared(), equalTo(false));
            assertThat(accountt.getCanOpenVirtualCard(), equalTo(true));
            assertThat(accountt.getCanOpenPlasticCard(), equalTo(false));
            assertThat(accountt.getIsMyShared(), equalTo(false));
            assertThat(accountt.getIsSupervised(), equalTo(false));
            assertThat(accountt.getOwnerId(), equalTo(30943));
            assertThat(accountt.getState(), equalTo("ACTIVE"));
            assertThat(accountt.getCanReorderVirtual(), equalTo(false));
            assertThat(accountt.getCanReorderPlastic(), equalTo(false));
            assertThat(accountt.getPlasticCardStatus(), equalTo("ACTIVE"));
            assertThat(accountt.getCanUnblockPlasticCard(), equalTo(false));
            assertThat(accountt.getCanLinkPlastic(), equalTo(false));
            assertThat(accountt.getCanUnblockVirtualCard(), equalTo(false));
        }
        softAssert.assertAll();
    }

    public void checkAllFieldsFromTelenorClientDiPAccounts2ResponseUnblockCard(ClientDiPAccounts2UnblockCard clientDiPAccounts2UnblockCard) {
        SoftAssert softAssert = new SoftAssert();
        List<Account> accounts = clientDiPAccounts2UnblockCard.getAccounts();
        for(Account accountt : accounts) {
            assertThat(accountt.getAccountId(), equalTo(9434));
            assertThat(accountt.getAccountName(), equalTo("Band 512047269"));
            softAssert.assertEquals(accountt.getCcy(), "HUF");
            assertThat(accountt.getCcyId(), equalTo(348));
            assertThat(accountt.getBalance(), notNullValue());
            assertThat(accountt.getAvailableBalance(), notNullValue());
            assertThat(accountt.getBlocked(), equalTo(0));
            //assertThat(accountt.getPlasticCardId(), equalTo(14932));
            //assertThat(accountt.getPlasticMaskedPan(), equalTo("545598******6620"));
            softAssert.assertTrue(accountt.getMain().equals(true), "Main is not true");
            assertThat(accountt.getIsDefault(), equalTo(true));
            assertThat(accountt.getOwn(), equalTo(true));
            assertThat(accountt.getShared(), equalTo(false));
            assertThat(accountt.getCanOpenVirtualCard(), equalTo(true));
            assertThat(accountt.getCanOpenPlasticCard(), equalTo(true));
            assertThat(accountt.getIsMyShared(), equalTo(false));
            assertThat(accountt.getIsSupervised(), equalTo(false));
            assertThat(accountt.getOwnerId(), equalTo(30943));
            assertThat(accountt.getState(), equalTo("ACTIVE"));
            assertThat(accountt.getCanReorderVirtual(), equalTo(false));
            assertThat(accountt.getCanReorderPlastic(), equalTo(false));
            //assertThat(accountt.getPlasticCardStatus(), equalTo("ACTIVE"));
            assertThat(accountt.getUnblockPlasticCardId(), equalTo(14932));
            assertThat(accountt.getCanUnblockPlasticCard(), equalTo(true));// false
            assertThat(accountt.getUnblockPlasticMaskedPan(), equalTo("545598******6620"));
            assertThat(accountt.getCanLinkPlastic(), equalTo(false));
            assertThat(accountt.getCanUnblockVirtualCard(), equalTo(false));
        }
        softAssert.assertAll();
    }

    public int getPlasticCardIdFromTelenorClientDiPAccounts2Response(ClientDiPAccounts clientDiPAccounts) {
        int plasticCardId = 0;
        List<Accountt> accounts = clientDiPAccounts.getAccounts();
        for(Accountt accountt : accounts) {
            plasticCardId = accountt.getPlasticCardId();
        }
        return plasticCardId;
    }

    public void checkFieldsInTelenorFullRegAuthAuthenticateResponse(AuthAuthenticate authAuthenticate) {
        assertThat(authAuthenticate.getClientFirstName(), equalTo("Pavel"));
        assertThat(authAuthenticate.getClientLastName(), equalTo("TestQA"));
        assertThat(authAuthenticate.getPresentedLogin(), equalTo("380980316499"));
        assertThat(authAuthenticate.getMainPhone(), equalTo("380980316499"));
        assertThat(authAuthenticate.getEmail(), equalTo("telenorchangeemailtest@mailsac.com"));//pavelqaemail@mailsac.com
    }

    public void checkFieldsInTelenorAuthAuthenticateResponse(AuthAuthenticate authAuthenticate) {
        assertThat(authAuthenticate.getId(), equalTo(30943));
        assertThat(authAuthenticate.getClientFirstName(), equalTo("Pavel"));
        assertThat(authAuthenticate.getClientLastName(), equalTo("Test"));
        assertThat(authAuthenticate.getPresentedLogin(), equalTo("380685448615"));
        assertThat(authAuthenticate.getCountryId(), equalTo(826));
        assertThat(authAuthenticate.getResidenceCountryId(), equalTo(616));
        assertThat(authAuthenticate.getLangId(), equalTo(1));
        assertThat(authAuthenticate.getMainPhone(), equalTo("380685448615"));
        assertThat(authAuthenticate.getEmail(), equalTo("assetspb@gmail.com"));
        assertThat(authAuthenticate.getEmailIsVerified(), equalTo(true));
        assertThat(authAuthenticate.getCurrencyId(), equalTo(348));
        assertThat(authAuthenticate.getSecQuestion(), equalTo("QA"));
        assertThat(authAuthenticate.getStateId(), equalTo(1));
        assertThat(authAuthenticate.getAddDocsAvail(), equalTo(false));
        assertThat(authAuthenticate.getCcyCode(), equalTo("HUF"));

        List<Address> addresses = authAuthenticate.getAddresses();
        for (Address address : addresses){
            assertThat(address.getTypeId(), equalTo(0));
            assertThat(address.getStreetLine1(), equalTo("address"));
            assertThat(address.getStreetLine2(), equalTo("address2"));
            assertThat(address.getCity(), equalTo("city"));
            assertThat(address.getZip(), equalTo("123456"));
            assertThat(address.getCountryId(), equalTo(616));
            break;
        }

        assertThat(authAuthenticate.getBirthDate(), equalTo("946677600000"));
        assertThat(authAuthenticate.getBirthDateAsDate(), equalTo("2000-01-01"));
        assertThat(authAuthenticate.getDdStatus(), equalTo("FDD"));
        assertThat(authAuthenticate.getCardholderName(), equalTo("Pavel Test"));
        assertThat(authAuthenticate.getClientIsNew(), equalTo(false));
        assertThat(authAuthenticate.getCardholderNameState(), equalTo("VERIFIED"));

        List<Imagesstatus> imagesstatuses = Collections.singletonList(authAuthenticate.getImagesStatus().get(0));
        for(Imagesstatus imagesstatus : imagesstatuses){
            assertThat(imagesstatus.getTypeId(), equalTo(1));
            assertThat(imagesstatus.getStateID(), equalTo(10));
            assertThat(imagesstatus.getImageType(), equalTo("SELFIE"));
            assertThat(imagesstatus.getImageState(), equalTo("APPROVED"));
            break;
        }

        Imagesstatus imagesstatus1 = authAuthenticate.getImagesStatus().get(1);
        assertThat(imagesstatus1.getTypeId(), equalTo(2));
        assertThat(imagesstatus1.getStateID(), equalTo(10));
        assertThat(imagesstatus1.getImageType(), equalTo("PHOTOID"));
        assertThat(imagesstatus1.getImageState(), equalTo("APPROVED"));

        Imagesstatus imagesstatus2 = authAuthenticate.getImagesStatus().get(2);
        assertThat(imagesstatus2.getTypeId(), equalTo(3));
        assertThat(imagesstatus2.getStateID(), equalTo(10));
        assertThat(imagesstatus2.getImageType(), equalTo("PROOFOFADDRESS"));
        assertThat(imagesstatus2.getImageState(), equalTo("APPROVED"));

        Imagesstatus imagesstatus3 = authAuthenticate.getImagesStatus().get(3);
        assertThat(imagesstatus3.getTypeId(), equalTo(4));
        assertThat(imagesstatus3.getStateID(), equalTo(10));
        assertThat(imagesstatus3.getImageType(), equalTo("SELFIE2"));
        assertThat(imagesstatus3.getImageState(), equalTo("APPROVED"));
    }

    public void read_write() throws IOException {
        FileReader fr = new FileReader("files/tokensForTelenorRegistration.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("files/used.txt");
        String line;

        while((line = br.readLine()) != null)
        {
            line = line.replaceAll("qwerty","qwerty HAHA");
            fw.write((line + "\n"), 0, (line+"\n").length());

        }
        fr.close();
        fw.close();

    }

    public static List<String> readFile(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            List<String> listOfData = new ArrayList<>();
            String d;
            while((d = br.readLine()) != null){
                listOfData.add(d);
            }
            return listOfData;
        }

    }

    public static String readFileReturnString(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String data = null;
            String d;
            while ((d = br.readLine()) != null) {
                data = d;
            }
            return data;
        }
    }

    public static void writeFile(List<String> listOfData, String path) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for(String str: listOfData){
                bw.write(str);
                bw.newLine();
            }
        }
    }

    public String getTokenFromFile(String path) throws IOException {
        String token = null;
        List<String> data = TelenorHelper.readFile(path);
        for (int i = 0; i < data.size(); i++){
            if(!data.contains("Expired")){
                if(!data.get(i).contains("Expired")){
                    token = data.get(i);
                    //token = tok;
                    data.set(i, data.get(i) + " Expired");
                    break;
                }

            }
//            else {
//                tok = data.get(0);
//                data.set(0, data.get(0) + " Expired");
//                break;
//            }

        }
        TelenorHelper.writeFile(data, "files/telenor/used.txt");
        List<String> data2 = TelenorHelper.readFile("files/telenor/used.txt");
        TelenorHelper.writeFile(data2, path);
        return token;
    }

    //@org.jetbrains.annotations.Nullable
//    public String getEmailConfirmationRegistrationTelenorLinkFromMailSac() throws InterruptedException {
//        Thread.sleep(4000);
//        Response res = given()
//                .header("Mailsac-Key", "k_T2K6ywY25Cej6ZsycegCoZNgAporSLPGeyCI")
//                .when()
//                .get("https://mailsac.com/api/addresses/pavelqaemail@mailsac.com/messages");
//
//        res.then().log().all();
//        Assert.assertEquals(res.getStatusCode(), 200);
//        Mailsacc[] mailsacc = res.as(Mailsacc[].class);
//
//        List<Mailsacc> mailsaccс = Arrays.asList(mailsacc);
//        String link_link = null;
//        for (int i = 0; i < mailsaccс.size(); i++){
//            List<String> emailLinks = mailsaccс.get(i) .getLinks();
//            System.out.println(emailLinks.get(0));
//            link_link = emailLinks.get(0);
//            break;
//        }
//        return link_link;
//    }

//    public String getChageEmailConfirmationTelenorLinkFromMailSac() throws InterruptedException {
//        Thread.sleep(4000);
//        Response res = given()
//                .header("Mailsac-Key", "k_T2K6ywY25Cej6ZsycegCoZNgAporSLPGeyCI")
//                .when()
//                .get("https://mailsac.com/api/addresses/telenorchangeemailtest@mailsac.com/messages");
//
//        res.then().log().all();
//        Assert.assertEquals(res.getStatusCode(), 200);
//        Mailsacc[] mailsacc = res.as(Mailsacc[].class);
//
//        List<Mailsacc> mailsaccс = Arrays.asList(mailsacc);
//        String link_link = null;
//        for (int i = 0; i < mailsaccс.size(); i++){
//            List<String> emailLinks = mailsaccс.get(i) .getLinks();
//            System.out.println("link: " + emailLinks.get(0));
//            link_link = emailLinks.get(0);
//            break;
//        }
//        return link_link;
//    }

    public String getEmailConfirmationTelenorLinkFromMailSac(String email) throws InterruptedException {
        Thread.sleep(4000);
        Response res = given()
                .header("Mailsac-Key", "k_T2K6ywY25Cej6ZsycegCoZNgAporSLPGeyCI")
                .when()
                .get("https://mailsac.com/api/addresses/"+email+"/messages");

        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(), 200);
        Mailsacc[] mailsacc = res.as(Mailsacc[].class);

        List<Mailsacc> mailsaccс = Arrays.asList(mailsacc);
        String link_link = null;
        for (int i = 0; i < mailsaccс.size(); i++){
            List<String> emailLinks = mailsaccс.get(i) .getLinks();
            System.out.println("link: " + emailLinks.get(0));
            link_link = emailLinks.get(0);
            break;
        }
        return link_link;
    }

    public void checkAllFieldsInTelenorHomePageAccountHistoryListResponse(AccountHistoryList accountHistoryList) {
        List<AccountHistoryList_> accountHistoryList1 = accountHistoryList.getAccountHistoryList();
        for (AccountHistoryList_ accountHistoryList_ :accountHistoryList1){
            assertThat(accountHistoryList_.getAmount(), equalTo(49000));
            assertThat(accountHistoryList_.getCcyId(), equalTo(348));
            assertThat(accountHistoryList_.getCcySymbol(), equalTo("Ft"));
            assertThat(accountHistoryList_.getFinType(), equalTo("D"));
            //assertThat(accountHistoryList_.getFullName(), equalTo("Telenor"));
            assertThat(accountHistoryList_.getId(), equalTo(618061));
            //assertThat(accountHistoryList_.getItemDateISO(), equalTo("2021-05-20 22:01:13.376647 Europe/Kiev"));
            assertThat(accountHistoryList_.getStateId(), equalTo(100));
            assertThat(accountHistoryList_.getTypeId(), equalTo(10));
            assertThat(accountHistoryList_.getTypeName(), equalTo("Fee"));
            assertThat(accountHistoryList_.getAccCcyId(), equalTo(348));
            assertThat(accountHistoryList_.getAccCcySymbol(), equalTo("Ft"));
            //assertThat(accountHistoryList_.getAccAmount(), equalTo(200000));
            break;
        }
    }

    public void createCardForToken(){
        given().log().uri().log().headers().log().body()
                .contentType("application/json")
                .auth().preemptive().basic("AQ", "EtKQZXS") //  vMFV55m
                //.header("Authorization", "Basic VEVEOmN0MTAyMDMw")
                .body("{\n" +
                        "\"requestId\": \"7fad7ade-84ba-409c-857d-" + generateRandomString(12) + "\",\n" +
                        "\"clientId\": \"4153\",\n" +
                        "\"program\": \"TELENOR\",\n" +
                        "\"currencyCode\": \"HUF\",\n" +
                        "\"cardType\": \"PLASTIC\",\n" +
                        "\"accountId\": \"\"\n" +
                        "}")
                .when()
                .post("https://lvov.csltd.com.ua/CustomerServicesDev/v1/card/create")
                .then().log().all();
                //.statusCode(400)
                //.body("errDesc", equalTo("Card not found"));
    }
}

