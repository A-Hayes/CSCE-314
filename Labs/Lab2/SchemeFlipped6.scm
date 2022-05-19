; Asa Hayes & Isabel Ramirez
; CSCE-314-502
; 4 Sep 2020
; Lab 2, Q3: Determines if sphere volume can fit into rect. prism given dimensions 

(define (sphereVol dm)
  (define rd (/ dm 2) )
  (/ (* 4 3.14 rd rd rd) 3)
)

(define (rectVol ht wd ln)
  (* ht wd ln)
)

(define (isContained dm ht wd ln)
  (if (<= (sphereVol dm) (rectVol ht wd ln) )
    #t
    #f
  )
)

(define (main)
  (if (isContained 15 10 8 45) 
    (display "The sphere's contents fits into the truck.") 
    (display "The sphere's contents do not fit into the truck.") 
  ) 
  (newline)
  (if (isContained 300 5 4 10) 
    (display "The sphere's contents fits into the truck.") 
    (display "The sphere's contents do not fit into the truck.") 
  ) 
  (newline)
)

(main)
(exit)