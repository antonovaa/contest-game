CREATE OR REPLACE FUNCTION find_account_by_guid(login TEXT) RETURNS TABLE(f1 int, f2 text)
   IS acc_bal NUMBER(11,2);
   BEGIN
      SELECT order_total
      INTO acc_bal
      FROM orders
      WHERE customer_id = acc_no;
      RETURN(acc_bal);
    END;