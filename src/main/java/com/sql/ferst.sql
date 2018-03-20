-- CREATE OR REPLACE FUNCTION find_account_id(username TEXT) RETURNS TABLE(f1 int, f2 text)
--    DECLARE
--    IS acc_bal NUMBER(11,2);
--    BEGIN
--       SELECT order_total
--       INTO acc_bal
--       FROM orders
--       WHERE customer_id = acc_no;
--       RETURN(acc_bal);
--     END ;
CREATE OR REPLACE FUNCTION public.add_user_role(p_username TEXT)
  RETURNS VOID
AS $$
BEGIN
--   SELECT u.id
--   FROM usersetails u
--   WHERE u.username = p_username;
  INSERT INTO public.userroles (user_id, role)
    SELECT
      u.id,
      'ADMIN'
    FROM usersetails u
    WHERE u.username = p_username;
END;
$$ LANGUAGE plpgsql;
